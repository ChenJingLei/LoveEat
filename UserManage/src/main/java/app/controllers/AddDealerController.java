package app.controllers;

import app.models.Dealer;
import app.models.ManageUser;
import app.models.UpdateUserStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HeZYSaaaaln on 2016/1/4.
 */
@RestController
@RequestMapping("/UserManage")
public class AddDealerController {
    @RequestMapping(value = "/addDealer", method = RequestMethod.POST)
    public UpdateUserStatus addInfoToDealer(@RequestBody Dealer paramDealer) {
        RestTemplate restTemplate = new RestTemplate();
        UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8090/Dealer/addDealer", paramDealer, UpdateUserStatus.class);
        return updateUserStatus;
    }

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    public UpdateUserStatus addInfoToManager(@RequestBody ManageUser paramManager) {
        RestTemplate restTemplate = new RestTemplate();
        UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8090/ManageUser/addManageUser", paramManager, UpdateUserStatus.class);
        return updateUserStatus;
    }

    @RequestMapping(value = "/addOpenIdToManager",method = RequestMethod.POST)
    public UpdateUserStatus addOpenIdToManager(@RequestBody ManageUser paramManager){
        RestTemplate restTemplate = new RestTemplate();
        UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8090/ManageUser/addOpenIdToManageUser",paramManager,UpdateUserStatus.class);
        return updateUserStatus;
    }

    @RequestMapping(value = "/addOpenIdToDealer",method = RequestMethod.POST)
    public UpdateUserStatus addOpenIdToDealer(@RequestBody ManageUser paramManager){
        RestTemplate restTemplate = new RestTemplate();
        UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8090/Dealer/addOpenIdToDealer",paramManager,UpdateUserStatus.class);
        return updateUserStatus;
    }



}
