package com.fh.dianshang.dao;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.vo.PinPaiData;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author cyl
 * @create 2021-01-13 18:48
 */
public interface PpDao {
    Integer queryDataCount(PinPaiData pinPaiData);

    List<PinPai> queryListDataByParams(PinPaiData pinPaiData);

    /*@Insert("insert into shop_paizi (name,bandE,imgpath,bandDesc,ord,isdel,createDate,updateDate,author) value" +
            "      (#{name},#{bandE},#{imgpath},#{bandDesc},#{ord},0,SYSDATE(),#{updateDate},#{author});")*/
    void addPp(PinPai pinPai);


    void updatePp(PinPai pinPai);

    List<PinPai> queryPinpaiData();
}
