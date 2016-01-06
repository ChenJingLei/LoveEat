package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

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
//
//        System.out.println(jsApiSignature.toString());
//        model.addAttribute(APPID, jsApiSignature.getAppid());
//        model.addAttribute(TIMESTAMP, jsApiSignature.getTimestamp());
//        model.addAttribute(NONCESTR, jsApiSignature.getNoncestr());
//        model.addAttribute(SIGNATURE, jsApiSignature.getSignature());
        return "views/goodsTest";
    }

    @RequestMapping(value = "/GoodsToDataBase/test", method = RequestMethod.GET)
    public String test(){
        return "views/goods";
    }

}
