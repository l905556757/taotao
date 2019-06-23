package com.taotao.manager.service.impl;

import com.taotao.manager.mapper.ItemMapper;
import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.manager.service.IItemDescService;
import com.taotao.manager.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends IBaseServiceImpl<Item> implements IItemService {

    @Autowired(required = false) IItemDescService iItemDescService;
    /**添加商品，和商品描述
     * @param item
     * @param itemDesc
     */
    @Override public void insertItem(Item item, String itemDesc) {
        //设置商品状态为正常
        item.setStatus(1);
        //调用实现的通用mapper先插入商品
        this.insert(item);

        ItemDesc itemDesc1 = new ItemDesc();
        itemDesc1.setItemId(item.getId());
        itemDesc1.setItemDesc(itemDesc);
        iItemDescService.insert(itemDesc1);

    }
}
