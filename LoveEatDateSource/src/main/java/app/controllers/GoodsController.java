package app.controllers;

import app.models.Goods;
import app.models.UpdateUserStatus;
import app.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HeZYSaaaaln on 2016/1/4.
 */
@RestController
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    private GoodsRepository repository;
    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public UpdateUserStatus addGoods (@RequestBody Goods paramGoods) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            System.out.println(paramGoods.toString());
            repository.save(paramGoods);
            updateUserStatus.setMsgCode("1");
            updateUserStatus.setResult(repository.findByNameAndPlace(paramGoods.getName(), paramGoods.getOplace()).getId().toString());
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
        try{
            if (repository.exists(paramGoods.getId())){
                Goods goods = repository.findOne(paramGoods.getId());
                goods.setUprice(paramGoods.getUprice());
                System.out.println(goods.toString());
                repository.save(goods);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            }else {
            updateUserStatus.setMsgCode("0");
            updateUserStatus.setResult("goods is not exists");
            }
        }catch (Exception e){
            updateUserStatus.setResult("failed:" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/updateNumToGoods", method = RequestMethod.POST)
    public UpdateUserStatus updateNumToGoods(@RequestBody Goods paramGoods) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try{
            if (repository.exists(paramGoods.getId())){
                Goods goods = repository.findOne(paramGoods.getId());
                goods.setNum(paramGoods.getNum());
                System.out.println(goods.toString());
                repository.save(goods);
                updateUserStatus.setMsgCode("1");
                updateUserStatus.setResult("successful");
            }else {
                updateUserStatus.setMsgCode("0");
                updateUserStatus.setResult("goods is not exists");
            }
        }catch (Exception e){
            updateUserStatus.setResult("failed:" + e.getMessage());
        }
        return updateUserStatus;
    }

    @RequestMapping(value = "/RemoveOrderForm/{qfid}", method = RequestMethod.DELETE)
    public UpdateUserStatus RemoveOrderForm(@PathVariable("qfid") Long qfid) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            if (repository.exists(qfid)) {
                System.out.println("");
                repository.delete(qfid);
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

