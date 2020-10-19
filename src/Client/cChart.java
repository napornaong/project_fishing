package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import ClientReceiveOb.ObDTO;
import ClientReceiveOb.setReceiveOb;
import Swing.allList;
import Swing.mainScr;
import Swing.select_graph;
import database.offerDTO;

public class cChart {
	private static cChart cChart = null;
	private Socket withServer = null;
	private Socket withServer1 = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois;
	private select_graph cG = null;
	private ClientCenter cCenter = null;
	private cChart cc = null;
	private setReceiveOb src = null;

	private cChart() {
		StartMain();
		receive();
		receiveOb();

	}

	public static cChart getInstance() {
		if (cChart == null) {
			cChart = new cChart();

		}
		return cChart;
	}

	public void SetcChart(Socket withServer, Socket withServer1, ClientCenter cCenter) {
		this.withServer = withServer;
		this.withServer1 = withServer1;
		this.cCenter = cCenter;

	}

	private void StartMain() {
		// TODO Auto-generated method stub
		new mainScr();
	}

	public void receiveOb() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					src = setReceiveOb.getInstance();

					while (true) {
						ois = new ObjectInputStream(withServer1.getInputStream());
						ArrayList<String[]> adto = (ArrayList<String[]>) ois.readObject();
						ArrayList<ObDTO> adto1=src.setList(adto);
						new allList(adto);
						
					}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void sendOb(offerDTO offer) {
		try {
			oos = new ObjectOutputStream(withServer1.getOutputStream());
			oos.writeObject(offer);
			oos.flush();
			oos.reset();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("제공되었습니다");
	}

	private void receive() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						System.out.println("aaaa");
						reMsg = withServer.getInputStream();
						byte[] reBuffer = new byte[1024];
						reMsg.read(reBuffer);
						String msg = new String(reBuffer);
						msg = msg.trim();
						System.out.println(msg + "qqqq");
						cCenter.cRmasAna(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		}).start();

	}

	public void send(String reMsg) {
		try {
			while (true) {
				sendMsg = withServer.getOutputStream();
				System.out.println("여기까진 왔어?");
				sendMsg.write(reMsg.getBytes());
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}

}
