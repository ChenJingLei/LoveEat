package app.controllers;

import app.models.UpdateUserStatus;
import app.models.ManageUser;
import app.repositories.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cjl20 on 2016/1/3.
 */
@RestController
@RequestMapping("/ManageUser")
public class ManageUserController {

    @Autowired
    private ManageUserRepository repository;

    @RequestMapping(value = "/addManageUser", method = RequestMethod.POST)
    public UpdateUserStatus addManageUser(@RequestBody ManageUser paramUser) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            repository.save(paramUser);
            updateUserStatus.setMsgCode("1");
            updateUserStatus.setResult(repository.findByNameAndPhone(paramUser.getName(), paramUser.getPhone()).getId().toString());
        } catch (DataIntegrityViolationException e) {
            updateUserStatus.setMsgCode("-1");
            updateUserStatus.setResult("data error");

        } catch (IncorrectResultSizeDataAccessException e) {
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("user already exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/addOpenIdToManageUser", method = RequestMethod.POST)
    public UpdateUserStatus addOpenIdToManageUser(@RequestBody ManageUser paramUser) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(paramUser.getId())) {
                ManageUser manageUser = repository.findOne(paramUser.getId());
                manageUser.setOpenid(paramUser.getOpenid());
                System.out.println(manageUser.toString());
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

    @RequestMapping(value = "/RemoveManageUser/{id}", method = RequestMethod.DELETE)
    public UpdateUserStatus RemoveManageUser(@PathVariable("id") Long id) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
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
