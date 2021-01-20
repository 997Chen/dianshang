package com.fh.dianshang.dao;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.List;

/**
 * @author cyl
 * @create 2021-01-18 18:47
 */
public interface SpDao {
    void addSp(ShangPin shangPin);

    Integer querySpCount(PinPaiData pinPaiData);

    List<PinPai> querySpData(PinPaiData pinPaiData);

    void deleteSp(Integer id);

    void updateSp(Integer id);
}
