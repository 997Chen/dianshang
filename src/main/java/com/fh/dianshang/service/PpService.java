package com.fh.dianshang.service;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-13 18:48
 */
public interface PpService {
    Map queryData(PinPaiData pinPaiData);

    void addPp(PinPai pinPai);

    void updatePp(PinPai pinPai);

    List<PinPai> queryPinpaiData();
}

