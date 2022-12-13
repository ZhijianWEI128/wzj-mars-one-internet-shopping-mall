package com.gec.service;

import com.gec.pojo.Shopcar;
import com.gec.pojo.Shopcars;
import com.gec.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopCarService {

    List<Shopcars> findShopCarsByUser(User user);

    void addToCart(int id,int num,int userid);

    void deleteCarByArticleIdAndUserId(Integer id, Integer userId);

    void updateCar(Shopcar shopcar);
}
