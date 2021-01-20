package com.fh.dianshang.service;

import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-18 18:46
 */
public interface SpService {
    void addSp(ShangPin shangPin);

    Map querySp(PinPaiData pinPaiData);

    void deleteSp(Integer id);
}
