package com.gec.service.impl;

import com.gec.mapper.ArticleMapper;
import com.gec.mapper.ShopcarMapper;
import com.gec.pojo.Shopcar;
import com.gec.pojo.ShopcarExample;
import com.gec.pojo.Shopcars;
import com.gec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ShopcarMapper shopcarMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Shopcars> findshopcarByUserIdAndId(Integer userId, int[] ids) {
        ShopcarExample shopcarExample = new ShopcarExample();
        ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        //获取当前用户所有购物车
        List<Shopcar> shopcars=shopcarMapper.selectByExample(shopcarExample);
        List<Shopcars> shopcarsList=new ArrayList<>();

        for (int i = 0; i < shopcars.size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if (i + 1 == ids[j]){
                    Shopcars shopcars1=new Shopcars();
                    shopcars1.setId(i+1);
                    shopcars1.setArticle(articleMapper.selectByPrimaryKey(shopcars.get(i).getArticleid()));
                    shopcars1.setBuynum(shopcars.get(i).getBuynum());
                    shopcarsList.add(shopcars1);
                }
            }
        }
        return shopcarsList;
    }
}
