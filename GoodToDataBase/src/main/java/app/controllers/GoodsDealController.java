package app.controllers;

import app.models.Goods;
import app.models.UpdateUserStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cjl20 on 2016/1/5.
 */
@Controller
public class GoodsDealController {

    private static String APPID = "appid";
    private static String TIMESTAMP = "timestamp";
    private static String NONCESTR = "nonceStr";
    private static String SIGNATURE = "signature";

    @RequestMapping(value = "/GoodsToDataBase", method = RequestMethod.GET)
    public String GoodsToDataBase(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        //String url = "http://112.64.107.129:8095/GoodsToDataBase";

        //JsApiSignature jsApiSignature = restTemplate.postForObject("http://localhost:80/getWeiXinConfig", url, JsApiSignature.class);

        /*
        appId: 'wxf8b4f85f3a794e77',
        timestamp: 1452049568,
        nonceStr: 'e3xXmt05XYv3VWMR',
        signature: '060fc29ca2dc9e9f04779c610e0525f15ddd6b90',
         */

//        JsApiSignature jsApiSignature = new JsApiSignature("aaaa", "bbbb", 123456, "dddd", "eeee");

//        System.out.println(jsApiSignature.toString());
//        model.addAttribute(APPID, jsApiSignature.getAppid());
//                model.addAttribute(APPID, "aaaaaaaaaaaa");
//        model.addAttribute(TIMESTAMP, jsApiSignature.getTimestamp());
//        model.addAttribute(NONCESTR, jsApiSignature.getNoncestr());
//        model.addAttribute(SIGNATURE, jsApiSignature.getSignature());
        return "views/goodsTobase";
    }

    @RequestMapping(value = "/GoodsToDataBase/test", method = RequestMethod.GET)
    public String test() {
        return "views/goods";
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    public String addGoods(Goods goods, Model model) {
        System.out.println(goods.toString());
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        try {
            RestTemplate restTemplate = new RestTemplate();
            updateUserStatus = restTemplate.postForObject("http://localhost:8090/Goods/addGoods", goods, UpdateUserStatus.class);
            System.out.println(updateUserStatus.toString());
            if (updateUserStatus.getMsgCode().equals("1")) {
                model.addAttribute("Goods", goods);
                return "views/goodsSuccess";
            } else {
                throw new Exception(updateUserStatus.getResult());
            }
        } catch (Exception e) {
            System.out.println(updateUserStatus.toString());
            model.addAttribute("Result", updateUserStatus.getResult());
            return "views/goodsFailed";
        }
    }

    private static String GOODS = "goods";
    private static String DATEFORMATE = "datefromate";

    @RequestMapping(value = "/GoodsShow/{gid}", method = RequestMethod.GET)
    public String GoodsShow(@PathVariable("gid") String id, Model model) {
        UpdateUserStatus updateUserStatus = new UpdateUserStatus();
        RestTemplate restTemplate = new RestTemplate();
        try {
//            updateUserStatus = restTemplate.getForObject("http://localhost:8090/Query/", UpdateUserStatus.class);
//           public Goods(String name, Long num, Float uprice, String oplace, Date mdate, String category, String barcode) {

            Goods goods = new Goods("猎豹牌蚊香", 100L, 13.5f, "上海", new Date(), "生活用品", "971231231231");
            model.addAttribute(GOODS, goods);
            model.addAttribute(DATEFORMATE, new SimpleDateFormat("yyyy年MM年dd日"));
            return "views/goodsShow";
        } catch (Exception e) {
            return "view/goodsFailed";
        }
    }
}
