package com.gec.service.impl;

import com.gec.mapper.ArticleMapper;
import com.gec.mapper.ShopcarMapper;
import com.gec.pojo.Shopcar;
import com.gec.pojo.ShopcarExample;
import com.gec.pojo.Shopcars;
import com.gec.pojo.User;
import com.gec.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    ShopcarMapper shopcarMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Shopcars> findShopCarsByUser(User user) {
        ShopcarExample shopcarExample = new ShopcarExample();
        ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
        criteria.andUseridEqualTo(user.getId());
        List<Shopcar> shopcars = shopcarMapper.selectByExample(shopcarExample);
        List<Shopcars> shopcars1 = new ArrayList<>();
        for (int i = 0; i < shopcars.size(); i++) {
            Shopcars shopcars2 = new Shopcars();
            shopcars2.setId(i+1);
            shopcars2.setArticle(articleMapper.selectByPrimaryKey(shopcars.get(i).getArticleid()));
            shopcars2.setBuynum(shopcars.get(i).getBuynum());
            shopcars1.add(shopcars2);
        }
        return shopcars1;
    }

    @Override
    public void addToCart(int id, int num,int userid) {
        ShopcarExample shopcarExample = new ShopcarExample();
        ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
        criteria.andArticleidEqualTo(id);
        criteria.andUseridEqualTo(userid);
        if(shopcarMapper.selectByExample(shopcarExample).size()==0){
            Shopcar shopcar=new Shopcar();
            shopcar.setArticleid(id);
            shopcar.setBuynum(num);
            shopcar.setUserid(userid);
            shopcarMapper.insert(shopcar);
        }else {
            List<Shopcar> shopcars= shopcarMapper.selectByExample(shopcarExample);
            shopcars.get(0).setBuynum(shopcars.get(0).getBuynum()+num);
            System.out.println(shopcars.get(0));
            shopcarMapper.updateByPrimaryKey(shopcars.get(0));

        }
    }

    @Override
    public void deleteCarByArticleIdAndUserId(Integer articleId, Integer userId) {
        ShopcarExample shopcarExample = new ShopcarExample();
        ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
        criteria.andArticleidEqualTo(articleId);
        criteria.andUseridEqualTo(userId);
        shopcarMapper.deleteByExample(shopcarExample);
    }

    @Override
    public void updateCar(Shopcar shopcar) {
        ShopcarExample shopcarExample = new ShopcarExample();
        ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
        criteria.andArticleidEqualTo(shopcar.getArticleid());
        criteria.andUseridEqualTo(shopcar.getUserid());
        List<Shopcar> shopcars= shopcarMapper.selectByExample(shopcarExample);
        shopcar.setId(shopcars.get(0).getId());
        shopcarMapper.updateByExample(shopcar,shopcarExample);
    }

}
