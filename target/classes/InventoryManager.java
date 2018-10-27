import java.util.HashMap;

public class InventoryManager {
	
	HashMap<Integer,InventoryInfoResponse>  inventory ; 
	public static final String STANDARD = "STANDARD";
	public static final String EXPRESS = "EXPRESS";
	
	public InventoryInfoResponse getInventoryInfo(int id){
	createRandomInventory();	
	return inventory.get(id);
	}
	
	createRandomInventory(){
	for(int i =0;i<5;i++) {
		InventoryInfoResponse inv = new InventoryInfoResponse();
			inv.setId(i);
			inv.setItemName(item+"_"+i);
			inv.setPrice(i*1000);
			inv.setRating(i+"star");
			inv.setAdUrl("url "+i+".com");
			inventory.add(i,inv);
			
	}	
	
	// date format input  20/02
	String getExtimatedDeilveryDate(int date,String delMethod){
		int day = Integer.parseInt(date.split("/")[0]);
		int month = Integer.parseInt(date.split("/")[1]);
		
		String deliveryDate = "";
		int delDay;
		int delMonth;
		
		if(STANDARD.equals(delMethod) ) {
			delDay = (day+6)%30;
			delMonth = (day+6) > 30 ? month+1:month;
			
			 return deliveryDate+delDay+delDay;
		}
		if(EXPRESS.equals(delMethod) ) {
			delDay = (day+6)%30;
			delMonth = (day+6) > 30 ? month+1:month;
			
			 return deliveryDate+delDay+delDay;
		}
	}

	}

}
