package com.gec.service.impl;

import com.gec.mapper.ArticleMapper;
import com.gec.pojo.Article;
import com.gec.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article findArticleById(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
