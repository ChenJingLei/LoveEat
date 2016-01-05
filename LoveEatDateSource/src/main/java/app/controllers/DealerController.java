package app.controllers;

import app.models.Dealer;
import app.models.ShowInfo;
import app.models.UpdateUserStatus;
import app.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/4.
 */

@RestController
@RequestMapping("/Dealer")
public class DealerController {
    @Autowired
    private DealerRepository repository;

    @RequestMapping(value = "/addDealer",method = RequestMethod.POST)
    public UpdateUserStatus addDealer (@RequestBody Dealer paramDealer){
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            System.out.println(paramDealer.toString());
            repository.save(paramDealer);
            updateUserStatus.setMsgCode("1");
            updateUserStatus.setResult(repository.findByNameAndPhone(paramDealer.getName(), paramDealer.getPhone()).getId());
        }catch (DataIntegrityViolationException e) {
            updateUserStatus.setMsgCode("-1");
            updateUserStatus.setResult("data error");
        }catch (IncorrectResultSizeDataAccessException e){
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("dealer already exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/addOpenIdToDealer", method = RequestMethod.POST)
    public UpdateUserStatus addOpenIdToDealer(@RequestBody Dealer paramDealer) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try{
            if (repository.exists(paramDealer.getId())) {
                Dealer dealer = repository.findOne(paramDealer.getId());
                dealer.setOpenid(paramDealer.getOpenid());
                System.out.println(dealer.toString());
                repository.save(dealer);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            }else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("dealer is not exists");
            }
        }catch (Exception e){
            updateUserStatus.setResult("failed:" + e.getMessage());
        }
        return updateUserStatus;
        }

    @RequestMapping(value = "/RemoveDealer/{id}", method = RequestMethod.DELETE)
    public UpdateUserStatus RemoveDealer(@PathVariable("id") String id) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(id)) {
                System.out.println(id);
                repository.delete(id);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("dealer is not exists");
            }
        }catch (Exception e) {
            updateUserStatus.setResult("failed" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/FindAll")
    public ShowInfo FindAll()
    {
        List<Dealer> list = repository.findAll();
        ShowInfo showInfo = new ShowInfo();
        try {
            showInfo.setMsgCode("1");
            showInfo.setResult("Success");
            showInfo.setList(list);
        }catch (Exception e){
            showInfo.setMsgCode("0");
            showInfo.setResult("Failed");
        }
        return showInfo;
    }
}

