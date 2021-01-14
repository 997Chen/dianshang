package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.AttributeDao;
import com.fh.dianshang.entity.po.Attribute;
import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-14 20:13
 */
@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeDao attributeDao;
    @Override
    public Map queryAttributeData(PinPaiData pinPaiData) {
        Map map = new HashMap();
        Integer count = attributeDao.queryDataCount(pinPaiData);
        List<Attribute> st = attributeDao.queryAttributeData(pinPaiData);
        map.put("count",count);
        map.put("list",st);
        return map;
    }

    @Override
    public void addAttribute(Attribute attribute) {
        attributeDao.addAttribute(attribute);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        attributeDao.updateAttribute(attribute);
    }

}
