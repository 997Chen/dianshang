package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.TypeDao;
import com.fh.dianshang.entity.po.Type;
import com.fh.dianshang.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cyl
 * @create 2021-01-12 16:45
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    public TypeDao typeDao;
    @Override
    public List<Type> getData() {

        return typeDao.getData();
    }

    @Override
    public List<Type> getDataByPid(Integer pid) {
        return typeDao.getDataByPid(pid);
    }
    @Override
    public void add(Type type) {
        typeDao.add(type);
    }

    @Override
    public void update(Type type) {
        typeDao.update(type);
    }

    @Override
    public Type toUpdate(Integer id) {
        return typeDao.toUpdate(id);
    }
}
