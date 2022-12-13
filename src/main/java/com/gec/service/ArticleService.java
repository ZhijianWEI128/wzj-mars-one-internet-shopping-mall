package com.gec.service;

import com.gec.pojo.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 首页商品查询
     * @param typecode
     * @return
     */
    List<Article> findArticlesByTypecode(String typecode);

}
