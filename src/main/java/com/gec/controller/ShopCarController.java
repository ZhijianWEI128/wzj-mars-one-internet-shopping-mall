package com.gec.controller;

import com.gec.pojo.Shopcar;
import com.gec.pojo.Shopcars;
import com.gec.pojo.User;
import com.gec.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;

    @RequestMapping("/ShowShopCarItemAction")
    public String ShowShopCarItemAction(Model model, HttpSession session){
        User user= (User) session.getAttribute("session_user");
        List<Shopcars> shopcars=shopCarService.findShopCarsByUser(user);
        model.addAttribute("shopCars",shopcars);
        int num=0;
        double totalmoney=0;
        for(Shopcars shopcar:shopcars){
            num=num+shopcar.getBuynum();
            totalmoney=totalmoney+shopcar.getArticle().getPrice()*shopcar.getArticle().getDiscount()*shopcar.getBuynum();
        }
        model.addAttribute("num",num);
        model.addAttribute("totalmoney",totalmoney);
        return "shopCar";
    }

    @RequestMapping("/buyAction")
    public String buyAction(Integer id,Integer buyNum ,HttpSession session){
        User user= (User) session.getAttribute("session_user");
        shopCarService.addToCart(id,buyNum,user.getId());
        return "forward:doItem";
    }

    @RequestMapping("/updateCar")
    public String updateCar(Integer id,HttpSession session,Integer buyNum){
        User user= (User) session.getAttribute("session_user");
        Shopcar shopcar=new Shopcar();
        shopcar.setArticleid(id);
        shopcar.setBuynum(buyNum);
        shopcar.setUserid(user.getId());
        shopCarService.updateCar(shopcar);
        return "forward:ShowShopCarItemAction";
    }

    @RequestMapping("/deleteCar")
    public String deleteCar(Integer id,HttpSession session){
        User user= (User) session.getAttribute("session_user");
        shopCarService.deleteCarByArticleIdAndUserId(id,user.getId());
        return "forward:ShowShopCarItemAction";
    }
}
