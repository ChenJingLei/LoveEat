package app.controllers;


import app.models.OrderForm;
import app.models.OrderFormStatus;
import app.models.ShowInfo;
import app.models.UpdateUserStatus;
import app.repositories.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/4.
 */
@RestController
@RequestMapping("/OrderForm")

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
            updateUserStatus.setResult("OrderForm already exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/RemoveOrderForm/{ofid}", method = RequestMethod.DELETE)
    public UpdateUserStatus RemoveOrderForm(@PathVariable("ofid") Long ofid) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(ofid)) {
                System.out.println(" ");
                repository.delete(ofid);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("OrderForm is not exists");
            }
        } catch (Exception e) {
            updateUserStatus.setResult("failed" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/QueryById/{ofid}", method = RequestMethod.GET)
    public OrderFormStatus QueryOrderFormById(@PathVariable("ofid") Long ofid){
        OrderFormStatus orderFormStatus = new OrderFormStatus();
        try{
            if (repository.exists(ofid)) {
                orderFormStatus.setMsgCode("1");
                orderFormStatus.setResult("Querying OrderForms successfully");
                orderFormStatus.setOrderform(repository.findByOfid(ofid));
            }else {
                orderFormStatus.setMsgCode("0");
                orderFormStatus.setResult("OrderForm is not existed");
            }
        } catch (Exception e) {
            orderFormStatus.setMsgCode("-1");
            orderFormStatus.setResult("Failed" + e.getMessage());
            }
        return orderFormStatus;
        }

    @RequestMapping(value = "/FindAll")
    public ShowInfo FindAll()
    {
        List<OrderForm> list = repository.findAll();
        ShowInfo showInfo = new ShowInfo();
        try {
            showInfo.setMsgCode("1");
            showInfo.setResult("You are successful");
            showInfo.setList(list);
        }catch (Exception e){
            showInfo.setMsgCode("0");
            showInfo.setResult("You are failed");
        }
        return showInfo;
    }
}
