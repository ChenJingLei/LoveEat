package app.controllers;

import app.models.IdentifyUser;
import app.models.IdentifyUserStatus;
import app.models.ManageUser;
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
public class UserController {

    @Autowired
    private ManageUserRepository manageUserRepository;


    //识别用户身份
    @RequestMapping(value = "/User/IdentifyUser", method = RequestMethod.GET)
    public IdentifyUserStatus IdentifyUser(@RequestParam(value = "OpenId") String OpenId) {
        IdentifyUserStatus identifyUserStatus = new IdentifyUserStatus();
        IdentifyUser identifyUser = new IdentifyUser();
        int identification = 0;
        ManageUser manageUser = manageUserRepository.findByOpenid(OpenId);

        if (manageUser != null) {
            identifyUser.setOpenid(OpenId);
            identifyUser.setIdentification(identification++);
            identifyUser.setName(manageUser.getName());
            identifyUser.setPhone(manageUser.getPhone());
        }

        identifyUserStatus.setMsgCode("1");
        identifyUserStatus.setResult(identifyUser);
        return identifyUserStatus;
    }
}
