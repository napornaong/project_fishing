package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Swing.allList;
import server.sChart;

public class offerDAO {
	private static  offerDAO oDAO = null;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private ArrayList<offerDTO> offerList = null;
	private sChart sc=sChart.getInstance();

	private offerDAO() {
		
		offerDAOLord();
		connect();
	}
	public static offerDAO getInstance() {
		if(oDAO==null) {
			oDAO=new offerDAO();
		}
		return oDAO;
	}
	

	private void offerDAOLord() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 로드 실패");
		}
	}

	private boolean connect() {
		// TODO Auto-generated method stub
		boolean cFlag = false;
		try {
			conn = DriverManager.getConnection("" + "jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결 성공");
			return cFlag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cFlag;
	}

	public ArrayList<offerDTO> setAll() {
		ArrayList<offerDTO> offerList = new ArrayList<>();
		offerDTO searOfferDTO = null;
		String sql = "select * from offer";
		if (connect()) {
			try {
				stmt = conn.createStatement();
				if (stmt != null) {
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						searOfferDTO = new offerDTO();
						searOfferDTO.setId(rs.getString("id"));
						searOfferDTO.setShipname(rs.getString("shipname"));
						searOfferDTO.setShipnum(rs.getString("shipnum"));
						searOfferDTO.setTotalNum(rs.getString("totalnum"));
						searOfferDTO.setDate1(rs.getString("date1"));
						searOfferDTO.setShipaddr(rs.getString("shipaddr"));
						searOfferDTO.setMoney(rs.getString("money"));
						offerList.add(searOfferDTO);
						
					}
					return offerList;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return offerList;
	}
	
	public ArrayList<String[]> setlocaldateList(String sendAddr ,String date1 ) {
		ArrayList<String[]> offerlocaldateList = new ArrayList<>();
		String sql;
		String addr=sendAddr;
		String date=date1;
		sql = "select shipaddr, shipname, date1, money,totalnum from offer where shipaddr='"+addr+"' and date1='"+date+"'"; 
		if (connect()) {
			try {
				stmt = conn.createStatement();
				if (stmt != null) {
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						 offerDTO searOfferDTO = new offerDTO();
						searOfferDTO.setShipaddr(rs.getString("shipaddr"));
						searOfferDTO.setShipname(rs.getString("shipname"));
						searOfferDTO.setDate1(rs.getString("date1"));
						searOfferDTO.setMoney(rs.getString("money"));
						searOfferDTO.setTotalNum(rs.getString("totalnum")); 
						
						offerlocaldateList.add(searOfferDTO.getArray());
						
					}
					return offerlocaldateList;
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return offerlocaldateList;
		
		
		
	}

	
	public ArrayList<String[]> setlocalList(String sendAddr ) {
		ArrayList<String[]> offerList = new ArrayList<>();
		String addr=sendAddr;
		
		String sql;
		if(addr.equals("전체")) {
			sql="select shipaddr, shipname, date1, money,totalnum from offer";
		}else {
			sql = "select shipaddr, shipname, date1, money,totalnum from offer where shipaddr='"+addr+"'";
		}                           
		if (connect()) {
			try {
				stmt = conn.createStatement();
				if (stmt != null) {
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						 offerDTO searOfferDTO = new offerDTO();
						searOfferDTO.setShipaddr(rs.getString("shipaddr"));
						searOfferDTO.setShipname(rs.getString("shipname"));
						searOfferDTO.setDate1(rs.getString("date1"));
						searOfferDTO.setMoney(rs.getString("money"));
						searOfferDTO.setTotalNum(rs.getString("totalnum")); 
						
						offerList.add(searOfferDTO.getArray());
						
					}
					return offerList;
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return offerList;
		
	}
	public int insertOffer(offerDTO offerDTOsear) {
		if (connect()) {
			try {
				String sql = "insert into offer values(offer_no.nextval,?,?,?,?,?,?,?)";
				PreparedStatement psmt;
				psmt = conn.prepareStatement(sql);
				offerDTO a = offerDTOsear;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, a.getId());
				psmt.setString(2, a.getShipname());
				psmt.setString(3, a.getShipnum());
				psmt.setString(4, a.getTotalNum());
				psmt.setString(5, a.getDate1());
				psmt.setString(6, a.getShipaddr());
				psmt.setString(7, a.getMoney());
				int k = psmt.executeUpdate();
				if(k>0) {
					String reMsg="offerok";
					sc.send(reMsg);
				}
				return k;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;

	}

}
