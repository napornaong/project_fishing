package server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Swing.dateInfo;
import Swing.login_1;
import database.DAOCenter;
import database.allDAO;
import database.allDTO;
import database.cDAO;
import database.cDTO;
import database.gDAO;
import database.gDTO;
import database.offerDAO;
import database.offerDTO;

public class ServerCenter {
	private static ServerCenter sCenter=null;
	gDAO DAOsear;
	gDTO DTOsear;
	cDTO cDTOsear;
	offerDTO oDTOsear;
	offerDAO oDAOsear;
	allDTO allDTOsear=new allDTO();
	String Log = null;
	DAOCenter dc = new DAOCenter();
	offerDAO oDAO=offerDAO.getInstance();
	private Socket withClient = null;
	private sChart sCh =sChart.getInstance();
	private ArrayList<allDTO> allList = new ArrayList<>();
	private ArrayList<cDTO> cList = new ArrayList<>();
	private ArrayList<gDTO> gList = new ArrayList<>();
	private ArrayList<sChart> sList = new ArrayList<>();
	private String remsg = null;
	private allDAO allSave = new allDAO();
	private cDAO cDAOsear= new cDAO();
	String Mem ="gmem";
	String allM="allmem";
	String Mem1 ="cmem";
	dateInfo reDate=new dateInfo();
	
	private ServerCenter() {
		
		
	}
	public static ServerCenter getInstance() {
		if(sCenter==null) {
			sCenter=new ServerCenter();
		}
		return sCenter;
	}
	
	
	public void addServerChat(sChart s) {
		sList.add(s);
	}
	
	public void sRmasAna(String msg) {
		String[] date=reDate.dateInfo1();
		String id = null;
		String pw = null;
		String d=date[0];
		String d1=date[1];
		String d2=date[2];
		String d3=date[3];
		String d4=date[4];
		String d5=date[5];
		String d6=date[6];
		String d7=date[7];
		String d8=date[8];
		
		if (msg.contains("samib/")) {
			int a = msg.indexOf("/");
			String reSmsg = msg.substring(a + 1);
			System.out.println(reSmsg + 111);
			CheckId(reSmsg);
		} else if (msg.contains("*joinG/")) {
			String remsgJG = msg;
			saveDB(remsgJG);
		} else if (msg.contains("*joinC/")) {
			String remsgJC = msg;
			saveCDB(remsgJC);
		}else if (msg.contains("checklog/")) {
			int a = msg.indexOf("/");
			String logRemsg = msg.substring(a + 1);
			StringTokenizer st = new StringTokenizer(logRemsg, "/");
			int countToken = st.countTokens();
			for (int i = 0; i < countToken; i++) {
				String remsg1 = st.nextToken();
				if (remsg1.contains("checkid*")) {
					int b = remsg1.indexOf("*");
					id = remsg1.substring(b + 1);
				} else if (remsg1.contains("checkpw*")) {
					int c = remsg1.indexOf("*");
					pw = remsg1.substring(c + 1);
				}
			}
			allSaveId(id, pw);
			
		}else if(msg.equals("SElocal")) {
			sCh.sendOb(oDAO.setlocalList("동남해"));
		
		}else if(msg.equals("ENlocal")) {
			sCh.sendOb(oDAO.setlocalList("북동해"));
		}else if(msg.equals("ESlocal")) {
			sCh.sendOb(oDAO.setlocalList("남동해"));
		}else if(msg.equals("SWlocal")) {
			sCh.sendOb(oDAO.setlocalList("서남해"));
		}else if(msg.equals("Wlocal")) {
			sCh.sendOb(oDAO.setlocalList("서해"));
			
		}else if(msg.equals("Alllocal")) {
			sCh.sendOb(oDAO.setlocalList("전체"));
			
		}else if(msg.equals("SElocal*d*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d));
		}else if(msg.equals("SElocal*d1*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d1));
		}else if(msg.equals("SElocal*d2*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d2));
		}else if(msg.equals("SElocal*d3*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d3));
		}else if(msg.equals("SElocal*d4*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d4));
		}else if(msg.equals("SElocal*d5*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d5));
		}else if(msg.equals("SElocal*d6*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d6));
		}else if(msg.equals("SElocal*d7*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d7));
		}else if(msg.equals("SElocal*d8*")) {
			sCh.sendOb(oDAO.setlocaldateList("동남해", d8));
		}else if(msg.equals("NElocal*d*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d));
		}else if(msg.equals("NElocal*d1*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d1));
		}else if(msg.equals("NElocal*d2*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d2));
		}else if(msg.equals("NElocal*d3*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d3));
		}else if(msg.equals("NElocal*d4*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d4));
		}else if(msg.equals("NElocal*d5*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d5));
		}else if(msg.equals("NElocal*d6*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d6));
		}else if(msg.equals("NElocal*d7*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d7));
		}else if(msg.equals("NElocal*d8*")) {
			sCh.sendOb(oDAO.setlocaldateList("북동해", d8));
		}else if(msg.equals("ESlocal*d*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d));
		}else if(msg.equals("ESlocal*d1*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d1));
		}else if(msg.equals("ESlocal*d2*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d2));
		}else if(msg.equals("ESlocal*d3*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d3));
		}else if(msg.equals("ESlocal*d4*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d4));
		}else if(msg.equals("ESlocal*d5*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d5));
		}else if(msg.equals("ESlocal*d6*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d6));
		}else if(msg.equals("ESlocal*d7*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d7));
		}else if(msg.equals("ESlocal*d8*")) {
			sCh.sendOb(oDAO.setlocaldateList("남동해", d8));
		}else if(msg.equals("SWlocal*d*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d));
		}else if(msg.equals("SWlocal*d1*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d1));
		}else if(msg.equals("SWlocal*d2*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d2));
		}else if(msg.equals("SWlocal*d3*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d3));
		}else if(msg.equals("SWlocal*d4*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d4));
		}else if(msg.equals("SWlocal*d5*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d5));
		}else if(msg.equals("SWlocal*d6*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d6));
		}else if(msg.equals("SWlocal*d7*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d7));
		}else if(msg.equals("SWlocal*d8*")) {
			sCh.sendOb(oDAO.setlocaldateList("서남해", d8));
		}else if(msg.equals("Wlocal*d*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d));
		}else if(msg.equals("Wlocal*d1*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d1));
		}else if(msg.equals("Wlocal*d2*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d2));
		}else if(msg.equals("Wlocal*d3*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d3));
		}else if(msg.equals("Wlocal*d4*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d4));
		}else if(msg.equals("Wlocal*d5*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d5));
		}else if(msg.equals("Wlocal*d6*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d6));
		}else if(msg.equals("Wlocal*d7*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d7));
		}else if(msg.equals("Wlocal*d8*")) {
			sCh.sendOb(oDAO.setlocaldateList("서해", d8));
		}
	}


	public ArrayList<allDTO> memList = allSave.initList();
	
	private void CheckId(String reSmsg) {
		// TODO Auto-generated method stub
		String newJName = reSmsg;
		String CkId="";
		if(newJName.length()<=10) {
			
			
			if(memList!=null) {
				
				for (allDTO see : memList) {
				
					if(!see.getId().equals(newJName)) {
					
					}else{
						CkId="samid";
						sCh.send(CkId);
						return;
					}
				}
				CkId="okid";
				sCh.send(CkId);
				
			}else {
				CkId="okid";
				sCh.send(CkId);
			}
		}else if(newJName.length()>10) {
			CkId="ovid";
			sCh.send(CkId);
		}
		
	}

	public void saveDB(String info) {
		DTOsear = new gDTO();
		String msg = info;
		
		String msgData = null;
		String id = null;
		String pw = null;
		String name = null;
		String pnum = null;
		if (msg.contains("*joinG/")) {
			int a = msg.indexOf("/");
			remsg = msg.substring(a + 1);
		}
		StringTokenizer st = new StringTokenizer(remsg, "/");
		int countToken = st.countTokens();
		for (int i = 0; i < countToken; i++) {
			msgData = st.nextToken();
			System.out.println(msgData + 111);
			if (msgData.contains("id*")) {
				int a = msgData.indexOf("*");
				id = msgData.substring(a + 1);
				DTOsear.setId(id);
				allDTOsear.setId(id);
				System.out.println(id);
			} else if (msgData.contains("pw*")) {
				int a = msgData.indexOf("*");
				pw = msgData.substring(a + 1);
				DTOsear.setPsw(pw);
				allDTOsear.setPw(pw);
				System.out.println(pw);
			} else if (msgData.contains("name*")) {
				int a = msgData.indexOf("*");
				name = msgData.substring(a + 1);
				DTOsear.setName(name);
				System.out.println(name);
			} else if (msgData.contains("pnum*")) {
				int a = msgData.indexOf("*");
				pnum = msgData.substring(a + 1);
				DTOsear.setPhone(pnum);
				System.out.println(pnum);
			}
		}
		dc.setInsert(Mem, DTOsear);
		dc.setInsert(allM, allDTOsear);
		
	}


	public void saveCDB(String info) {
		String msg = info;
		cDTOsear = new cDTO();
		String msgData = null;
		if (msg.contains("*joinC/")) {
			int a = msg.indexOf("/");
			remsg = msg.substring(a + 1);
		}
		StringTokenizer st = new StringTokenizer(remsg, "/");
		int countToken = st.countTokens();
		for (int i = 0; i < countToken; i++) {
			msgData = st.nextToken();
			if (msgData.contains("id*")) {
				int a = msgData.indexOf("*");
				String id = msgData.substring(a + 1);
				cDTOsear.setId(id);
				allDTOsear.setId(id);
			} else if (msgData.contains("pw*")) {
				int a = msgData.indexOf("*");
				String pw = msgData.substring(a + 1);
				cDTOsear.setPw(pw);
				allDTOsear.setPw(pw);
			} else if (msgData.contains("cname*")) {
				int a = msgData.indexOf("*");
				String name = msgData.substring(a + 1);
				cDTOsear.setName(name);
			} else if (msgData.contains("ponenum*")) {
				int a = msgData.indexOf("*");
				String pnum = msgData.substring(a + 1);
				cDTOsear.setPnum(pnum);
			} else if (msgData.contains("spne*")) {
				int a = msgData.indexOf("*");
				String shipname = msgData.substring(a + 1);
				cDTOsear.setShipname(shipname);
			} else if (msgData.contains("shipnum*")) {
				int a = msgData.indexOf("*");
				String shipnum = msgData.substring(a + 1);
				Integer Intshipnum = Integer.valueOf(Integer.parseInt(shipnum));
				cDTOsear.setShipnum(Intshipnum);
			} else if (msgData.contains("har*")) {
				int a = msgData.indexOf("*");
				String shipaddr = msgData.substring(a + 1);
				cDTOsear.setShipaddr(shipaddr);
			}

		}
		System.out.println("!@#!@#");
		dc.setInsert(Mem1, cDTOsear);
		dc.setInsert(allM, allDTOsear);
	}


	private void allSaveId(String id, String pw) {
		ArrayList<allDTO> memList = allSave.initList();
		ArrayList<cDTO> cList= cDAOsear.setAll();
		int cFlag=0;
		for (allDTO see : memList) {
			
			if (see.getId().equals(id) && see.getPw().equals(pw)) {
				cFlag=1;// 로그인 된거 확인 
				break;
			}
		}
		if(cFlag==1) {
			for(cDTO q: cList) {
				if(q.getId().equals(id)) {
					cFlag=2;//선장회원 로그인
					break;
				}
			}if(cFlag==1) {
				cFlag=3;//일반회원 로그인 
			}
		}if(cFlag==0) {
			Log="logF*";
			sCh.send(Log);
		}else if(cFlag==2) {
			Log = "clogok*";
			sCh.send(Log+id);
		}else if(cFlag==3) {
			Log = "glogok*";
			sCh.send(Log+id);
		}
			
						
	}

}
