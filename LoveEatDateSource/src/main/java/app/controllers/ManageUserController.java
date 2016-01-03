package app.controllers;

import app.models.AddUserStatus;
import app.models.ManageUser;
import app.repositories.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NonUniqueResultException;

/**
 * Created by cjl20 on 2016/1/3.
 */
@RestController
public class ManageUserController {

    @Autowired
    private ManageUserRepository repository;

    @RequestMapping(name = "/ManageUser/addManageUser", method = RequestMethod.GET)
    public AddUserStatus addManageUser(@RequestParam(value = "name") String name, @RequestParam(value = "phone") String phone) {
        AddUserStatus addUserStatus = new AddUserStatus("-1", "none");
        try {
            ManageUser manageUser = new ManageUser(name, phone);
            repository.save(manageUser);
            addUserStatus.setMsgCode("1");
            addUserStatus.setResult(repository.findByNameAndPhone(name, phone).getId().toString());
        } catch (DataIntegrityViolationException e) {
            addUserStatus.setMsgCode("-1");
            addUserStatus.setResult("data error");

        } catch (IncorrectResultSizeDataAccessException e) {
            addUserStatus.setMsgCode("0");
            addUserStatus.setResult("user already exists");
        }
        return addUserStatus;
    }


}
