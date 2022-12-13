package com.gec.controller;

import com.gec.pojo.Shopcars;
import com.gec.pojo.User;
import com.gec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/doOrder")
    public String doOrder(HttpSession session, int[] orderInfo){
        User user=(User) session.getAttribute("session_user");
        List<Shopcars> shopcars=orderService.findshopcarByUserIdAndId(user.getId(),orderInfo);
        session.setAttribute("shopCars",shopcars);
        double totalMoney=0;
        for (Shopcars shopcar : shopcars) {
            totalMoney = totalMoney + shopcar.getBuynum() * shopcar.getArticle().getPrice() * shopcar.getArticle().getDiscount();
        }
        session.setAttribute("totalMoney",totalMoney);
        return "order";
    }
}
