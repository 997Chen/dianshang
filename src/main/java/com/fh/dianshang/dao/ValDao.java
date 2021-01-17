package com.fh.dianshang.dao;

import com.fh.dianshang.entity.po.Val;
import com.fh.dianshang.entity.vo.PinPaiData;

import java.util.List;

/**
 * @author cyl
 * @create 2021-01-17 19:17
 */
public interface ValDao {
    Integer queryvalDataByIdCount(PinPaiData pinPaiData);

    List<Val> queryvalDataByIdData(PinPaiData pinPaiData);

    void addVal(Val val);
}
