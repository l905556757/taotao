package com.taotao.manager.controller;

import com.taotao.manager.pojo.Item;
import com.taotao.manager.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired(required = false)
    IItemService iItemService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addItem(Item item, String itemDesc) {
        iItemService.insertItem(item,itemDesc);

    }
}
