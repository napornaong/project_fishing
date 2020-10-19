package Swing;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Client.cChart;
import java.awt.event.ActionListener;


public class mainGScr extends JFrame {

	JLabel ImgBox;
	private JLabel ImgBoxW1;
	private JLabel ImgBoxE2;
	private JLabel ImgBoxS2;
	private JLabel ImgBoxE1;
	private JLabel ImgBoxE1_1;
	private JLabel ImgBoxS2_1;
	private JLabel ImgBoxS1_1;
	private JLabel ImgBoxS1;
	private final Action action = new SwingAction();
	private JTextField textField;
	private cChart cc=cChart.getInstance();
	private String remsg=null;
	
	
	/**
	 * Create the frame.
	 * @param logId 
	 * @return 
	 */

	
	
	public mainGScr(String logId) {
		dateInfo redate=new dateInfo();
		String[] header=redate.dateInfo1();

		
		String contents[][] = { { "" }, { "" }, { "" }, { "" }, { "" } };
		DefaultTableModel tableModel = new DefaultTableModel(contents, header);
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		DefaultTableCellRenderer renderer=new TableCellrenderer();
		table.getColumn(header[0]).setCellRenderer(renderer);
		table.getColumn(header[1]).setCellRenderer(renderer);
		table.getColumn(header[2]).setCellRenderer(renderer);
		table.getColumn(header[3]).setCellRenderer(renderer);
		table.getColumn(header[4]).setCellRenderer(renderer);
		table.getColumn(header[5]).setCellRenderer(renderer);
		table.getColumn(header[6]).setCellRenderer(renderer);
		table.getColumn(header[7]).setCellRenderer(renderer);
		table.getColumn(header[8]).setCellRenderer(renderer);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

			}
		});
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().setFocusable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 670);
		getContentPane().setLayout(null);
	

		scrollPane.setBounds(73, 364, 309, 191);
		getContentPane().add(scrollPane);
		table.setRowHeight(30);

		String header1[] = { "지역" };
		String contents1[][] = { { "북동해" }, { "남동해" }, { "서남해" }, { "동남해" }, { "서해" } };
		DefaultTableModel tableModel1 = new DefaultTableModel(contents1, header1);
		JTable table_1 = new JTable(tableModel1);
		JScrollPane scrollPane1 = new JScrollPane(table_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table_1.setBounds(12, 371, 62, 179);

		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().setFocusable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 670);
		getContentPane().setLayout(null);

		scrollPane1.setBounds(10, 364, 300, 191);
		getContentPane().add(scrollPane1);
		table_1.setRowHeight(30);
		JLabel lblNewLabel = new JLabel("Fishing Day");
		lblNewLabel.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		lblNewLabel.setBounds(39, 12, 123, 34);
		getContentPane().add(lblNewLabel);
		ImageIcon img=new ImageIcon("map2.jpg");
		ImageIcon img1=new ImageIcon("남해(4~10) 벤자리.jpg");
		ImageIcon img2=new ImageIcon("남해(4~10)돌돔.jpg");
		ImageIcon img3=new ImageIcon("남해(5~10) 혹돔.jpg");
		ImageIcon img4=new ImageIcon("남해(6~10) 자라바.jpg");
		ImageIcon img5=new ImageIcon("동해 (8~2) 방어.jpg");
		ImageIcon img6=new ImageIcon("동해(1~12) 감성돔.jpg");
		ImageIcon img7=new ImageIcon("동해(1~12) 벵에돔.jpg");
		ImageIcon img8=new ImageIcon("서해 (1~12) 농어.jpg");
		ImageIcon img9=new ImageIcon("서해 (4~10) 참돔.jpg");
		ImageIcon img0=new ImageIcon("서해 (5~11) 우럭.jpg");

		
		
//		ImgBox = new JLabel(img5);
//		ImgBox.setBounds(0, 80, img5.getIconWidth(), img5.getIconHeight());
//		getContentPane().add(ImgBox);
		JButton btnS = new JButton("s1");
		btnS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remsg="SElocal";
				cc.send(remsg);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImgBoxS1.setVisible(true);
				ImgBoxS1_1.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImgBoxS1.setVisible(false);
				ImgBoxS1_1.setVisible(false);
			}
		});
		btnS.setBounds(250, 273, 11, 11);
		getContentPane().add(btnS);
		
		
		
		
		
		JButton btnE_2 = new JButton("e1");
		btnE_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				remsg="ENlocal";
				cc.send(remsg);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImgBoxE1.setVisible(true);
				ImgBoxE1_1.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ImgBoxE1.setVisible(false);
				ImgBoxE1_1.setVisible(false);
			}
		});
		btnE_2.setBounds(286, 128, 11, 11);
		getContentPane().add(btnE_2);
		
		
		
		
		
		JButton btnE = new JButton("e2");
		btnE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remsg="ESlocal";
				cc.send(remsg);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImgBoxE2.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImgBoxE2.setVisible(false);
			}
		});
		btnE.setBounds(314, 204, 11, 11);
		getContentPane().add(btnE);

		
		JButton btnS_1 = new JButton("s2");
		btnS_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				remsg="SWlocal";
				cc.send(remsg);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImgBoxS2.setVisible(true);
				ImgBoxS2_1.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImgBoxS2.setVisible(false);
				ImgBoxS2_1.setVisible(false);
			}
		});
		btnS_1.setBounds(129, 293, 11, 11);
		getContentPane().add(btnS_1);
		
		
		
		
		JButton btnW = new JButton("w1");
		btnW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cc.send("Wlocal");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ImgBoxW1.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImgBoxW1.setVisible(false);
			}
		});
		
		

		
		
		
		btnW.setSelected(true);
		btnW.setBounds(25, 190, 11, 11);
		getContentPane().add(btnW);
		
		
		Image img1_1=img1.getImage();
		Image changedImg1=img1_1.getScaledInstance(60, 50, Image.SCALE_SMOOTH);
		ImageIcon img11=new  ImageIcon(changedImg1);
		ImgBoxE1_1 = new JLabel(img11);
		ImgBoxE1_1.setBounds(311, 129, 62, 37);
		getContentPane().add(ImgBoxE1_1);
		ImgBoxE1_1.setVisible(false);
		
		Image img4_4=img4.getImage();
		Image changedImg4=img4_4.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img44=new  ImageIcon(changedImg4);
		ImgBoxS1 = new JLabel(img44);
		ImgBoxS1.setBounds(263, 249, 62, 42);
		getContentPane().add(ImgBoxS1);
		ImgBoxS1.setVisible(false);
		
		
		
		Image img5_5=img5.getImage();
		Image changedImg5=img5_5.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img55=new  ImageIcon(changedImg5);
		ImgBoxS1_1= new JLabel(img55);
		ImgBoxS1_1.setBounds(263, 293, 62, 37);
		getContentPane().add(ImgBoxS1_1);
		ImgBoxS1_1.setVisible(false);
		
		
		Image img7_7=img7.getImage();
		Image changedImg7=img7_7.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img77=new  ImageIcon(changedImg7);
		ImgBoxS2_1= new JLabel(img77);
		ImgBoxS2_1.setBounds(143, 293, 62, 37);
		getContentPane().add(ImgBoxS2_1);
		ImgBoxS2_1.setVisible(false);
		
		Image img2_2=img2.getImage();
		Image changedImg2=img2_2.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img22=new  ImageIcon(changedImg2);
		ImgBoxE1 = new JLabel(img22);
		ImgBoxE1.setBounds(314, 80, 62, 37);
		getContentPane().add(ImgBoxE1);
		ImgBoxE1.setVisible(false);
		
		Image img6_6=img6.getImage();
		Image changedImg6=img6_6.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img66=new  ImageIcon(changedImg6);
		ImgBoxS2= new JLabel(img66);
		ImgBoxS2.setBounds(143, 249, 62, 37);
		getContentPane().add(ImgBoxS2);
		ImgBoxS2.setVisible(false);
		
		
		Image img3_3=img3.getImage();
		Image changedImg3=img3_3.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img33=new  ImageIcon(changedImg3);
		ImgBoxE2 = new JLabel(img33);
		ImgBoxE2.setBounds(330, 190, 62, 37);
		getContentPane().add(ImgBoxE2);
		ImgBoxE2.setVisible(false);
		
		Image img8_8=img8.getImage();
		Image changedImg8=img8_8.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon img88=new  ImageIcon(changedImg8);
		ImgBoxW1 = new JLabel(img88);
		ImgBoxW1.setBounds(39, 141, 62, 37);
		getContentPane().add(ImgBoxW1);
		ImgBoxW1.setVisible(false);
		
		
		ImgBox = new JLabel(img);
		ImgBox.setBounds(0, 80, img.getIconWidth(), img.getIconHeight());
		getContentPane().add(ImgBox);
		
		
		String GlogOn=null;
		
		
		String idlog=logId;
		JLabel lblNewLabel_11 = new JLabel(idlog+"님");
		lblNewLabel_11.setBounds(257, 22, 104, 18);
		getContentPane().add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("전체예약보기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc.send("Alllocal");
			}
		});
	
		btnNewButton.setBounds(10, 334, 116, 27);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cc.send("SElocal*d*");
			}
		});
		btnNewButton_1.setBounds(12, 576, 83, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cc.send("SElocal*d1*");
			}
		});
		btnNewButton_2.setBounds(107, 576, 83, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cc.send("ENlocal*d*");
			}
		});
		btnNewButton_3.setBounds(202, 576, 83, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cc.send("Wlocal*d*");
			}
		});
		btnNewButton_4.setBounds(297, 576, 74, 23);
		getContentPane().add(btnNewButton_4);
		setVisible(true);
		

		
		
		
		
	
		
		

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
