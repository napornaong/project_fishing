package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.offerDAO;

public class localList extends JFrame{
	JPanel cP;
	DefaultListModel<String> lm = new DefaultListModel<String>();
		String header[] = {  "지역", "배이름", "날짜(시간)","금액","인원" };
		DefaultTableModel tableModel = new DefaultTableModel(null, header);
		JTable table = new JTable(tableModel);
		JScrollPane tableScroll = new JScrollPane(table);
		ArrayList<String[]> initList=new ArrayList<>();
	JTextField[] indata = new JTextField[4];

	JPopupMenu popup;
	JMenuItem m_del, m_mod;

	int modIntRow = -1;

	offerDAO sqlDAO = offerDAO.getInstance();
	String loginId = null;
	 String localV=null;
	Color green = new Color(000,102,000);
	Color red = new Color(204,000,000);


	public localList(String localV){
		super("지역리스트");
		this.localV=localV;
		
		this.setLayout(new BorderLayout());
		this.setBounds(100, 100, 650, 550);
		tableSetting();
		initlocal(loginId );
		createC();	
		
		
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initlocal(String localV) {
		String sendAddr=localV;
		initList=sqlDAO.setlocalList(sendAddr);
		for(int i=0 ; i < initList.size(); i++) {
			tableModel.addRow(initList.get(i));
			System.out.println(initList.get(i));
		}
		
	}


	public void tableSetting() {	
		table.setRowMargin(0);
		table.getColumnModel().setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//마우스 클릭 줄값 텍스트필드에 세팅
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					int column = table.columnAtPoint(e.getPoint());
					int row = table.rowAtPoint(e.getPoint());
					table.changeSelection(row, column, false, false);
					modIntRow = table.getSelectedRow();
					for (int i = 0; i < indata.length; i++) {
						indata[i].setText((String) table.getValueAt(modIntRow, i));
					}
				}
				if (e.getClickCount() == 2) {
				}
				if (e.getButton() == 3) {
					
				}
			}
		});

		DefaultTableCellRenderer ts = new DefaultTableCellRenderer();
		ts.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc = table.getColumnModel();
		for (int i = 0; i < tc.getColumnCount(); i++) {
			tc.getColumn(i).setCellRenderer(ts);
		}

	}
	

	private void createC() {
		cP = new JPanel();
		cP.setLayout(new BorderLayout());
		cP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(cP, "Center");
		
		//JTable product 세팅
		JPanel cP_n = new JPanel();
		cP_n.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		cP.add(cP_n, "North");
		cP_n.add(tableScroll);
		tableScroll.setPreferredSize(new Dimension(370,400));
		
		
			
			
		}
		
	

}

