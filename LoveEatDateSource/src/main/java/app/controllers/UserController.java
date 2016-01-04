package app.controllers;

import app.models.Dealer;
import app.models.IdentifyUser;
import app.models.IdentifyUserStatus;
import app.models.ManageUser;
import app.repositories.DealerRepository;
import app.repositories.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjl20 on 2016/1/3.
 */
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private ManageUserRepository manageUserRepository;

    @Autowired
    private DealerRepository dealerRepository;

    //识别用户身份
    @RequestMapping(value = "/IdentifyUser", method = RequestMethod.GET)
    public IdentifyUserStatus IdentifyUser(@RequestParam(value = "OpenId") String OpenId) {
        IdentifyUserStatus identifyUserStatus = new IdentifyUserStatus();
        IdentifyUser identifyUser = new IdentifyUser();
        identifyUserStatus.setMsgCode("1");
        try {
            ManageUser manageUser = manageUserRepository.findByOpenid(OpenId);
            Dealer dealer = dealerRepository.findByOpenid(OpenId);

            if (dealer != null) {

                identifyUser.setOpenid(OpenId);
                identifyUser.setIdentification(1);
                identifyUser.setName(dealer.getName());
                identifyUser.setPhone(dealer.getPhone());
            }
            if (manageUser != null) {
                identifyUser.setOpenid(OpenId);
                identifyUser.setIdentification(2);
                identifyUser.setName(manageUser.getName());
                identifyUser.setPhone(manageUser.getPhone());
            }
            if (manageUser == null && dealer == null) {
                identifyUserStatus.setMsgCode("0");
                identifyUserStatus.setResult(null);
            } else if (manageUser != null && dealer != null){
                identifyUser.setIdentification(3);

            }
        } catch (Exception e) {
            identifyUserStatus.setMsgCode("-1");
            identifyUserStatus.setResult(identifyUser);
        }
        identifyUserStatus.setResult(identifyUser);
        return identifyUserStatus;
    }
}
