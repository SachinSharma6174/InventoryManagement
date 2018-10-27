import java.nio.file.AccessDeniedException;

import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;
import com.paytmmoney.client.util.HeadersUtil;
import com.paytmmoney.mf.transaction.dto.MfSipDTO;
import com.paytmmoney.mf.transaction.dto.response.MetaDTO;
import com.paytmmoney.mf.transaction.dto.response.ResponseDTO;
import com.paytmmoney.mf.transaction.exceptions.ApplicationException;
import com.paytmmoney.mf.transaction.exceptions.ApplicationExceptionHandler;
import com.paytmmoney.mf.transaction.exceptions.SuccessCode;


@Controller
@RequestMapping(value = "/inventory")
public class InventoryController {

	
	@GetMapping(value = "/get/{id}")
    @ResponseBody
    public ResponseDTO getInventoryById(@PathVariable(name = "id", required = true) Long id) {
        ImmutableMap<String, String> paramsCopy = ImmutableMap.of("getRegisteredSip", id.toString());
        InventoryInfoResponse response = InventoryManager.getInventoryInfo( id);
        return response;
    }

}
