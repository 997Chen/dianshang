package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.SpDao;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.service.SpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cyl
 * @create 2021-01-18 18:46
 */
@Service
public class SpServiceImpl implements SpService {
    @Resource
    private SpDao spDao;

    @Override
    public void addSp(ShangPin shangPin) {
        spDao.addSp(shangPin);
    }
}
