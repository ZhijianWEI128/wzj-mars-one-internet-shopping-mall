package com.gec.service;

import com.gec.pojo.ArticleType;

import java.util.List;

public interface ArticleTypeService {
    /**
     * 查询一级分类
     * @return
     */
    List<ArticleType> findFirstArticleTypes();

    List<ArticleType> findFirstArticleTypes(String typec4ode);
}
