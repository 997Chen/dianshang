package com.fh.dianshang.service;

import com.fh.dianshang.entity.po.Val;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-17 19:17
 */
public interface ValService {

    Map queryvalDataById(PinPaiData pinPaiData);

    void addVal(Val val);
}
