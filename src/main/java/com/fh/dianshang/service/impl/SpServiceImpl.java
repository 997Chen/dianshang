package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.SpDao;
import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.service.SpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map querySp(PinPaiData pinPaiData) {
        Map map= new HashMap<>();
        Integer count = spDao.querySpCount(pinPaiData);
        List<PinPai> st = spDao.querySpData(pinPaiData);
        map.put("count",count);
        map.put("list",st);
        return map;
    }

    @Override
    public void deleteSp(Integer id) {
        spDao.deleteSp(id);

    }
}
