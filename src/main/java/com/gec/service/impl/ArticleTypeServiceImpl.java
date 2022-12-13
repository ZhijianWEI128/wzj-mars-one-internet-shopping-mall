package com.gec.service.impl;

import com.gec.mapper.ArticleTypeMapper;
import com.gec.pojo.ArticleType;
import com.gec.pojo.ArticleTypeExample;
import com.gec.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //创建对象
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired //注入对象
    ArticleTypeMapper articleTypeMapper;


    @Override
    public List<ArticleType> findFirstArticleTypes() {
        //掉mapper方法
        //一级分类 code 4

        ArticleTypeExample articleTypeExample = new ArticleTypeExample();
        ArticleTypeExample.Criteria criteria = articleTypeExample.createCriteria();
        //一级分类 code 4
        criteria.andCodeLike("____");

        return articleTypeMapper.selectByExample(articleTypeExample);
    }

    @Override
    public List<ArticleType> findFirstArticleTypes(String typecode) {
        return articleTypeMapper.findSecondArticleTypes(typecode == null?"%":typecode+"%");
    }


}
