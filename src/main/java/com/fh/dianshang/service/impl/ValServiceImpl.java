package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.ValDao;
import com.fh.dianshang.entity.po.Val;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.service.ValService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-17 19:17
 */
@Service
public class ValServiceImpl implements ValService {
    @Resource
    private ValDao valDao;

    @Override
    public Map queryvalDataById(PinPaiData pinPaiData) {
        Map map=new HashMap();
        Integer valCount =valDao.queryvalDataByIdCount(pinPaiData);
        List<Val> valList=valDao.queryvalDataByIdData(pinPaiData);
        map.put("count",valCount);
        map.put("data",valList);
        return map;
    }

    @Override
    public void addVal(Val val) {
        valDao.addVal(val);
    }

    @Override
    public void delValById(Integer id) {
        valDao.delValById(id);
    }

    @Override
    public void updateVal(Val val) {
        valDao.updateVal(val);
    }

    @Override
    public List<Val> getvalDataById(Integer attrId) {

        return valDao.getvalDataById(attrId);
    }


}
