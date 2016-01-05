package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

/**
 * Created by cjl20 on 2016/1/5.
 */
@Controller
public class GoodsDealController {

    @RequestMapping(value = "/GoodsToDataBase", method = RequestMethod.GET)
    public String GoodsToDataBase(Model model) {
        model.addAttribute("aaaa","bbbb");
        model.addAttribute("ccc","ddd");
        return "views/goods";
    }

}
