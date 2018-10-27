
import java.util.HashMap;

public class InventoryManager {
	
	
	public static final String STANDARD = "STANDARD";
	public static final String EXPRESS = "EXPRESS";
	
	public InventoryInfoResponse getInventoryInfo(int id){
		HashMap<Integer,InventoryInfoResponse>  inventory = null ; 
	createRandomInventory(inventory);	
	return inventory.get(id);
	}
	
	public void createRandomInventory(HashMap<Integer,InventoryInfoResponse>  inventory ){
	for(int i =0;i<5;i++) {
		InventoryInfoResponse inv = new InventoryInfoResponse();
			inv.setId(i);
			inv.setItemName("item_"+i);
			inv.setPrice(i*1000);
			inv.setRating(i+"star");
			inv.setAdUrl("url "+i+".com");
			inventory.put(i,inv);
			
	}	
	}
	
	// date format input  20/02
	  public LogisticResponse getExtimatedDeilveryDate(String date ,String delMethod){
		int day = Integer.parseInt(date.split("/")[0]);
		int month = Integer.parseInt(date.split("/")[1]);
		LogisticResponse response = new LogisticResponse();
		
		String deliveryDate = "";
		int delDay;
		int delMonth;
		
		if(STANDARD.equals(delMethod) ) {
			delDay = (day+6)%30;
			delMonth = (day+6) > 30 ? month+1:month;
			
			deliveryDate =  deliveryDate+delDay+delDay;
		}
		if(EXPRESS.equals(delMethod) ) {
			delDay = (day+6)%30;
			delMonth = (day+6) > 30 ? month+1:month;
			
			deliveryDate =  deliveryDate+delDay+delDay;
		}
		
		response.setDateofOrder(date);
		response.setDeliverydate(deliveryDate);
		response.setDeliveryethod(delMethod);
		
		return response;
	}

	}


