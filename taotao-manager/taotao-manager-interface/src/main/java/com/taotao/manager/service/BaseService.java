package com.taotao.manager.service;

import java.util.List;

/**
 * @author lwy
 * @create 2019-06-20 11:50
 */
public interface BaseService<T> {

    public void insert(T t);

    public void delete(T t);

    public int deleteByIds(List<Object> list);

    public void update(T t);

    public T selectById(int id);

    public List<T> selectAll();

    public List<T> selectByPage(int page,int rows);
}
