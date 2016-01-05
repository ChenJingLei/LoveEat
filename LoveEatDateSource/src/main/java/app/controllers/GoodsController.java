package app.controllers;

import app.models.Goods;
import app.models.ShowInfo;
import app.models.UpdateUserStatus;
import app.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/4.
 */
@RestController
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsRepository repository;

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    public UpdateUserStatus addGoods(@RequestBody Goods paramGoods) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            System.out.println(paramGoods.toString());
            repository.save(paramGoods);
            updateUserStatus.setMsgCode("1");
            updateUserStatus.setResult(repository.findByNameAndOplace(paramGoods.getName(), paramGoods.getOplace()).getId().toString());
        } catch (DataIntegrityViolationException e) {
            updateUserStatus.setMsgCode("-1");
            updateUserStatus.setResult("data error");
        } catch (IncorrectResultSizeDataAccessException e) {
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("goods already exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/updatePriceToGoods", method = RequestMethod.POST)
    public UpdateUserStatus updatePriceToGoods(@RequestBody Goods paramGoods) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(paramGoods.getId())) {
                Goods goods = repository.findOne(paramGoods.getId());
                goods.setUprice(paramGoods.getUprice());
                System.out.println(goods.toString());
                repository.save(goods);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("goods is not exists");
            }
        } catch (Exception e) {
            updateUserStatus.setResult("failed:" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/updateNumToGoods", method = RequestMethod.POST)
    public UpdateUserStatus updateNumToGoods(@RequestBody Goods paramGoods) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(paramGoods.getId())) {
                Goods goods = repository.findOne(paramGoods.getId());
                goods.setNum(paramGoods.getNum());
                System.out.println(goods.toString());
                repository.save(goods);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("goods is not exists");
            }
        } catch (Exception e) {
            updateUserStatus.setResult("failed:" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/RemoveGoods/{id}", method = RequestMethod.DELETE)
    public UpdateUserStatus RemoveOrderForm(@PathVariable("id") Long id) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(id)) {
                System.out.println("");
                repository.delete(id);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            } else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("goods is not exists");
            }
        } catch (Exception e) {
            updateUserStatus.setResult("failed" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/Query/{name}", method = RequestMethod.GET)
    public UpdateUserStatus QueryGoods(@PathVariable("name") String name) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult(repository.findByName(name).toString());
        } catch (Exception e) {
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("Goods is not exists");
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/FindAll")
    public ShowInfo FindAll()
    {
        List<Goods> list = repository.findAll();
        ShowInfo showInfo = new ShowInfo();
        try {
            showInfo.setList(list);
            showInfo.setMsgCode("1");
            showInfo.setResult("Correct");
        }catch (Exception e){
            showInfo.setMsgCode("0");
            showInfo.setResult("Wrong");
        }
        return showInfo;
    }
}


