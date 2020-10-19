package ClientReceiveOb;

import java.util.ArrayList;

public class setReceiveOb {
	
private static setReceiveOb setOb=null;

private setReceiveOb() {
		
		
	}
	public static setReceiveOb getInstance() {
		if(setOb==null) {
			setOb=new setReceiveOb();
		}
		return setOb;
	}
	
	public ArrayList<ObDTO> setList(ArrayList<String[]> adto){
		ArrayList<ObDTO>oList =new ArrayList<>();
		
		if(!adto.equals(null)) {
			for(int i = 0; i<adto.size();i++) {
				
				ObDTO reObList =new ObDTO();
				
				reObList.setShipaddr(adto.get(i)[0]);
				reObList.setShipname(adto.get(i)[1]);
				reObList.setDate(adto.get(i)[2]);
				reObList.setManey(adto.get(i)[3]);
				reObList.setTotalnum(adto.get(i)[4]);
				oList.add(reObList);
				
			}
			
		}
		return oList;
		
	}
}
