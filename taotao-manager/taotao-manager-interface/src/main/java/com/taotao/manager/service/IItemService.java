package com.taotao.manager.service;

import com.taotao.manager.pojo.Item;

public interface IItemService extends IBaseService<Item>{
    void insertItem(Item item, String itemDesc);
}
