package ClientReceiveOb;

import database.offerDTO;

public class ObDTO {
	
	String shipaddr;
	String shipname;
	String date;
	String money;
	String totalnum;
	public ObDTO() {
		
	}

	public String getShipaddr() {
		return shipaddr;
	}
	public void setShipaddr(String shipaddr) {
		this.shipaddr = shipaddr;
	}
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getManey() {
		return money;
	}
	public void setManey(String maney) {
		this.money = maney;
	}
	public String getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(String totalnum) {
		this.totalnum = totalnum;
	}
	public String []getReArra(){
		String [] returnReData =new String[5];
		returnReData [0]=this.shipaddr;
		returnReData [1]=this.shipname;
		returnReData [2]=this.date;
		returnReData [3]=this.money;
		returnReData [4]=this.totalnum;
		return returnReData;
	}
}
