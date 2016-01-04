package app.controllers;


import app.models.OrderForm;
import app.models.UpdateUserStatus;
import app.repositories.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HeZYSaaaaln on 2016/1/4.
 */
@RestController
@RequestMapping("/OrderFrom")

public class OrderFormController {
    @Autowired
    private OrderFormRepository repository;
    @RequestMapping(value = "/addOrderForm",method = RequestMethod.POST)
    public UpdateUserStatus addOrderForm (@RequestBody OrderForm paraForm) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            repository.save(paraForm);
            updateUserStatus.setMsgCode("1");
            updateUserStatus.setResult(repository.findByGidAndDid(paraForm.getGid(), paraForm.getDid()).getOfid().toString());
        }catch (DataIntegrityViolationException e) {
            updateUserStatus.setMsgCode("-1");
            updateUserStatus.setResult("data error");
        }catch (IncorrectResultSizeDataAccessException e) {
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("user already exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/RemoveOrderForm/{ofid}", method = RequestMethod.DELETE)
    public UpdateUserStatus RemoveGoods(@PathVariable("ofid") Long ofid) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(ofid)) {
                System.out.println(" ");
                repository.delete(ofid);
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
