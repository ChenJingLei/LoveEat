package app.controllers;

import app.models.UpdateUserStatus;
import app.models.ManageUser;
import app.repositories.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjl20 on 2016/1/3.
 */
@RestController
public class ManageUserController {

    @Autowired
    private ManageUserRepository repository;

    @RequestMapping(name = "/ManageUser/addManageUser", method = RequestMethod.GET)
    public UpdateUserStatus addManageUser(@RequestParam(value = "name") String name, @RequestParam(value = "phone") String phone) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus("-1", "none");
        try {
            ManageUser manageUser = new ManageUser(name, phone);
            repository.save(manageUser);
            updateUserStatus.setMsgCode("1");
            updateUserStatus.setResult(repository.findByNameAndPhone(name, phone).getId().toString());
        } catch (DataIntegrityViolationException e) {
            updateUserStatus.setMsgCode("-1");
            updateUserStatus.setResult("data error");

        } catch (IncorrectResultSizeDataAccessException e) {
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("user already exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(name = "/ManageUser/addOpenIdToManageUser", method = RequestMethod.GET)
    public UpdateUserStatus addOpenIdToManageUser(@RequestParam(value = "Id") Long id, @RequestParam(value = "OpenId") String OpenId) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus("-1", "none");
        try {
            if (repository.exists(id)) {
                ManageUser manageUser = repository.findOne(id);
                manageUser.setOpenId(OpenId);
                repository.save(manageUser);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("user is not exists");
            }
        } catch (Exception e) {
            updateUserStatus.setResult("failed:" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(name = "/ManageUser/RemoveManageUser", method = RequestMethod.GET)
    public UpdateUserStatus RemoveManageUser(@RequestParam(value = "Id") Long id) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus("-1", "none");
        try {
            if (repository.exists(id)) {
                repository.delete(id);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("user is not exists");
            }
        } catch (Exception e) {
            updateUserStatus.setResult("failed" + e.getMessage());
        }
        return updateUserStatus;
    }
}
