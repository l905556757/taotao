package com.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.taotao.manager.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author lwy
 * @description
 * @create 2019-06-20 15:01
 */
public class IBaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    private Mapper<T> mapper;

    //将泛型类型作为成员变量，且在无参创建对象时就将其赋值
    private Class<T> clazz;

    public IBaseServiceImpl(){
        //通过反射获取带有泛型的父类，并将其强转获取为带有泛型的数据类型
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取带有泛型的数据类型的数组
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
    }
    @Override public void insert(T t) {
        mapper.insert(t);
    }

    @Override public void delete(T t) {
        mapper.delete(t);
    }

    @Override public int deleteByIds(List<Object> list) {
        Example example = new Example(clazz);
        example.createCriteria().andIn("id",list);
        int i = mapper.deleteByExample(example);
        return i;
    }

    @Override public void update(T t) {
        mapper.updateByPrimaryKeySelective(t);

    }

    @Override public T selectById(int id) {
        T t = mapper.selectByPrimaryKey(id);
        return t;
    }

    @Override public List<T> selectByObj(T t) {
        List<T> select = mapper.select(t);
        return select;
    }

    @Override public List<T> selectAll() {
        List<T> lists = mapper.selectAll();
        return lists;
    }

    @Override public List<T> selectByPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<T> select = mapper.select(null);
        return select;
    }
}
