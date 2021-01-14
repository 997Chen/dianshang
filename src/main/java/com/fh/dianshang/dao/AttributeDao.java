package com.fh.dianshang.dao;

import com.fh.dianshang.entity.po.Attribute;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.List;

/**
 * @author cyl
 * @create 2021-01-14 20:14
 */
public interface AttributeDao {
    Integer queryDataCount(PinPaiData pinPaiData);

    List<Attribute> queryAttributeData(PinPaiData pinPaiData);

    void addAttribute(Attribute attribute);
}
