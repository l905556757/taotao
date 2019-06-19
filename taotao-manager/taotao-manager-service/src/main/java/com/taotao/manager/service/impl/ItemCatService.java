package com.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwy
 * @create 2019-06-13 20:03
 */
@Service
public class ItemCatService implements IItemCatService {

    @Autowired private ItemCatMapper itemCatMapper;

    @Override public List<ItemCat> queryItemCatByPage(int page, int rows) {

        PageHelper.startPage(page, rows);//设置分页条件

        List<ItemCat> itemCats = this.itemCatMapper.select(null);
        return itemCats;
    }
}
