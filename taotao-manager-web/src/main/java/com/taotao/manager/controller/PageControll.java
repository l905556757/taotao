package com.taotao.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lwy
 * @description
 * @create 2019-06-20 20:19
 */
@Controller
@RequestMapping("page")
public class PageControll {
    //ip/rest/page/index
    @RequestMapping("{pageName}")
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }
}
