package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import database.IDcheck;

public class sMain {


	public static void main(String[] args) throws IOException {
		
		Socket withClient =null;
		ServerSocket serverS=new ServerSocket();
		ServerSocket serverS1=new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.47",8888));
		serverS1.bind(new InetSocketAddress("10.0.0.47",9999));
		ArrayList<Socket>cList =new ArrayList<>();
		ServerCenter sc=ServerCenter.getInstance();
		while(true) {
			System.out.println("서버대기중");
			withClient = serverS.accept();
			cList.add(withClient);

			System.out.println(cList);
			System.out.println(withClient.getInetAddress()+"클라이언트 접속 함");
			sChart s= sChart.getInstance();
			s.SetsChart(withClient, serverS1, sc);

			sc.addServerChat(s);
			s.start();
		}
		
	}

}
