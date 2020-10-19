package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class cMain {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		ClientCenter cCenter = ClientCenter.getInstance();
		Socket withServer = new Socket("10.0.0.47",8888);
		Socket withServer1 =new Socket("10.0.0.47",9999);
		cChart c=cChart.getInstance();
		c.SetcChart(withServer, withServer1, cCenter);
	}
}
