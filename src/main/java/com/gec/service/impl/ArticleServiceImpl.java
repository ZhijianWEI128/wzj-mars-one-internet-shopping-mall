package com.gec.service.impl;

import com.gec.mapper.ArticleMapper;
import com.gec.pojo.Article;
import com.gec.pojo.ArticleExample;
import com.gec.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> findArticlesByTypecode(String typecode) {
        if(typecode == null){
            typecode = "";
        }

        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();

        criteria.andTypeCodeLike(typecode+"%");

        return articleMapper.selectByExample(articleExample);
    }
}
