package com.fh.dianshang.dao;

import com.fh.dianshang.entity.po.Attrdatas;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author cyl
 * @create 2021-01-20 19:33
 */
public interface AttrdataDao {
    /*@Insert("<script>insert into shop_product_attrdatas (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> " +
            "( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  </foreach> </script>")*/
    void adds(List<Attrdatas> adList);
}
