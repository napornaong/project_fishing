package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import database.offerDAO;
import database.offerDTO;

public class sChart extends Thread{
	
	private static sChart sChart=null;
	private  Socket withClient =null;
	private  ServerCenter a=null;
	private ServerSocket serverS1;
	private Socket withClient1=null;
	private InputStream reMsg=null;
	private OutputStream sendMsg =null;
	private ObjectInputStream ois;
	private PrintWriter printWriter;
	
	private offerDAO oDAO=null;
	private offerDTO oDTO=null;
	private ObjectOutputStream oos=null;
	
	 private sChart() {
		
		 
	 }
	 public void SetsChart(Socket withClient, ServerSocket serverS1 ,ServerCenter a) {
		 this.withClient=withClient;
		 this.serverS1=serverS1;
		 this.a=a;
		 oDAO=offerDAO.getInstance();
	 }
	 
	 public static sChart getInstance() {
		 if(sChart==null) {
			 sChart=new sChart();
			
		 }
		return sChart;
	 }
	 
	 
	 
	 @Override
		public void run() {
			// TODO Auto-generated method stub
		 	receive();
		 	receiveOb();
		}
	
	 
	 public void receiveOb() {
		 new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					
					withClient1=serverS1.accept();
	
					while(true) {
						ois=new ObjectInputStream(withClient1.getInputStream());
						offerDTO adto=(offerDTO)ois.readObject();
						oDAO.insertOffer(adto);
						
				}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 }).start();
		
	 }
	 public void sendOb(ArrayList<String[]> offerList ) {
		 try {
			 oos = new ObjectOutputStream(withClient1.getOutputStream());
			 oos.writeObject(offerList);
			 oos.flush();
			 oos.reset();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("제공되었습니다");
	 }
	 
	 public void receive() {
		 new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					try {
						while(true) {
						reMsg=withClient.getInputStream();
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
						String msg= new String(reBuffer);
						msg=msg.trim();
						
						System.out.println("aqssqs");
						
						a.sRmasAna(msg);
						
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
		 }).start();
			 
		
	 }
	
	public void send(String reMsg) {
		 try {
			sendMsg = withClient.getOutputStream();
			System.out.println(reMsg+13);
			sendMsg.write(reMsg.getBytes());
			System.out.println("갔니?");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		 
		 
	 }
	
	




	 
	 
	 
}






