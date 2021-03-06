package com.taotao.manager.controller;

import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lwy
 * @create 2019-06-13 20:24
 */
@Controller
@RequestMapping("item/cat")
public class ItemCatController {

    @Autowired(required = false) private IItemCatService iItemCatService;

    // http://127.0.0.1:8081/rest/item/cat/query/1?rows=2
    @RequestMapping("query/{page}")
    @ResponseBody
    public List<ItemCat> queryItemCatsByPage(@PathVariable("page") int page, @RequestParam("rows") int rows) {
        List<ItemCat> itemCats = iItemCatService.selectByPage(page, rows);

        return itemCats;
    }

    /**
     * 根据商品类目父id查询子类目
     *
     * @param parentId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ItemCat> queryItemCatsByPatentId(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(parentId);
        List<ItemCat> itemCats = iItemCatService.selectByObj(itemCat);

        return itemCats;
    }
}

