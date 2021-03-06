package com.fh.dianshang.dao;

import com.fh.dianshang.entity.po.Type;

import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-12 16:47
 */
public interface TypeDao {
    List<Type> getData();

    List<Type> getDataByPid(Integer pid);


    void add(Type type);

    void update(Type type);

    Type toUpdate(Integer id);
}
