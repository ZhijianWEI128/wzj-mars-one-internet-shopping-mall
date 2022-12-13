package com.gec.controller;

import com.gec.pojo.Article;
import com.gec.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/doItem")
    public String doItem(Model model,int id){
        Article article=itemService.findArticleById(id);
        model.addAttribute("article",article);
        return "item";
    }
}
