package com.fh.dianshang.service;

import com.fh.dianshang.entity.po.Attrdatas;
import com.fh.dianshang.entity.po.ShangPin;

/**
 * @author cyl
 * @create 2021-01-20 19:32
 */
public interface AttrdataService {
    void addAttrdata(ShangPin shangPin, String attr, String sku);
}
