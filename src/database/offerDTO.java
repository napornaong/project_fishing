package database;

import java.io.Serializable;

public class offerDTO implements Serializable{
	private String id;
	private String shipname;
	private String shipnum;
	private String totalNum;
	private String date1;
	private String money;
	private String shipaddr;
	
	public offerDTO() {
		
	}
	public String getShipaddr() {
		return shipaddr;
	}
	public void setShipaddr(String shipaddr) {
		this.shipaddr = shipaddr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getShipnum() {
		return shipnum;
	}
	public void setShipnum(String shipnum) {
		this.shipnum = shipnum;
	}
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String[] getArray(){
		String [] returnData =new String[5];
		returnData [0]=this.shipaddr;
		returnData [1]=this.shipname;
		returnData [2]=this.date1;
		returnData [3]=this.money;
		returnData [4]=this.totalNum;
		return returnData;
		
	}
}
