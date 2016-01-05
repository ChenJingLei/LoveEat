package app.controllers;

import app.models.OrderForm;
import app.models.ShowInfo;
import app.models.UpdateUserStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HeZYSaaaaln on 2016/1/5.
 */
@RestController
@RequestMapping("/OrderFormManage")
public class OrderFormManageController {
        @RequestMapping(value = "/addForm", method = RequestMethod.POST)
        public UpdateUserStatus addInfoToOrderForm(@RequestBody OrderForm paramForm) {
            RestTemplate restTemplate = new RestTemplate();
            UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8090/OrderForm/addOrderForm", paramForm, UpdateUserStatus.class);
            return updateUserStatus;
        }

        @RequestMapping(value = "/deleteForm/{ofid}", method = RequestMethod.DELETE)
        public UpdateUserStatus delInfoToOrderForm(@PathVariable("ofid") Long ofid) {
            RestTemplate restTemplate = new RestTemplate();
            UpdateUserStatus updateUserStatus = new UpdateUserStatus();
            try
            {
                restTemplate.delete("http://localhost:8090/OrderForm/RemoveOrderForm/"+ofid);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            }catch (Exception e){
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("failed");
            }
            return updateUserStatus;
        }

        @RequestMapping(value = "/queryForm/{ofid}", method = RequestMethod.GET)
        public UpdateUserStatus QueryOrderForm (@PathVariable("ofid") Long ofid){
            RestTemplate restTemplate = new RestTemplate();
            UpdateUserStatus updateUserStatus = restTemplate.getForObject("http://localhost:8090/OrderForm/Query/{ofid}",UpdateUserStatus.class,ofid);
            return updateUserStatus;
        }

        @RequestMapping(value = "/ShowInfo")
        public ShowInfo showInfo()
        {
            RestTemplate restTemplate = new RestTemplate();
            ShowInfo findall = restTemplate.getForObject("http://localhost:8090/OrderForm/FindAll", ShowInfo.class);
            return findall;
        }
}
