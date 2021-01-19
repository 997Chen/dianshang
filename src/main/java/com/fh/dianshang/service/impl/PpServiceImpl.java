package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.PpDao;
import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.service.PpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-13 18:48
 */
@Service
public class PpServiceImpl implements PpService {
    @Resource
    private PpDao ppDao;
    @Override
    public Map queryData(PinPaiData pinPaiData) {
        Map map = new HashMap<>();
        Integer count = ppDao.queryDataCount(pinPaiData);
        List<PinPai> st = ppDao.queryListDataByParams(pinPaiData);
        map.put("count",count);
        map.put("list",st);
        return map;
    }

    @Override
    public void addPp(PinPai pinPai) {
        ppDao.addPp(pinPai);
    }

    @Override
    public void updatePp(PinPai pinPai) {
        ppDao.updatePp(pinPai);
    }

    @Override
    public List<PinPai> queryPinpaiData() {

        return  ppDao.queryPinpaiData();
    }

}
