import java.nio.file.AccessDeniedException;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/inventory")
public class InventoryController {

	
	@GetMapping(value = "/get/{id}")
    @ResponseBody
    public InventoryInfoResponse getInventoryById(@PathVariable(name = "id", required = true) int id) {
		InventoryManager manager = new  InventoryManager();
        InventoryInfoResponse response = manager.getInventoryInfo( id);
        return response;
    }
	
	@GetMapping(value = "/getEstimatedDelivery/{date}/{delMethod}")
    @ResponseBody
    public   LogisticResponse getInventoryById(@PathVariable(name = "date", required = true) String date ,@PathVariable(name = "delMethod", required = true) String delMethod ) {
		InventoryManager manager = new  InventoryManager();
		LogisticResponse  response = manager.getExtimatedDeilveryDate(date,delMethod);
        return response;
    }
	

}
