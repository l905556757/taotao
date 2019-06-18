package com.taotao.manager.service;

import com.taotao.manager.pojo.ItemCat;

import java.util.List;

/**
 * @author lh
 * @create 2019-06-13 19:30
 */
public interface ItemCatInterface {
    /**
     * @param page
     * @param rows
     * @return
     */
    List<ItemCat> queryItemCatByPage(int page, int rows);
}
