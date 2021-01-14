package com.fh.dianshang.service;

import com.fh.dianshang.entity.po.Attribute;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-14 20:12
 */
public interface AttributeService {
    Map queryAttributeData(PinPaiData pinPaiData);

    void addAttribute(Attribute attribute);

    void updateAttribute(Attribute attribute);
}
