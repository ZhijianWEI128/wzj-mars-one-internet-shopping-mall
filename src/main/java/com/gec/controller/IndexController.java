package com.gec.controller;

import com.gec.pojo.Article;
import com.gec.pojo.ArticleType;
import com.gec.service.ArticleService;
import com.gec.service.ArticleTypeService;
import com.gec.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller  //创建对象
public class IndexController {

    @Autowired
    ArticleTypeService articleTypeService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/toIndex") //请求映射
    public String toIndex(Model model,String typecode){
        //查询一级分类
        List<ArticleType> firstArticleTypes = articleTypeService.findFirstArticleTypes();
        //保存数据
        model.addAttribute("firstArticleTypes",firstArticleTypes);

        //查询二级分类
        List<ArticleType> secondArticleTypes=articleTypeService.findFirstArticleTypes(typecode);
        //保存二级分类的数据
        model.addAttribute("allSecondArticleTypes",secondArticleTypes);

        //返回类型的code
        model.addAttribute("typecode",typecode);

        //查询商品数据
        List<Article> articleList = articleService.findArticlesByTypecode(typecode);
        model.addAttribute("articles",articleList);
        return "list";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "login";
    }
}
