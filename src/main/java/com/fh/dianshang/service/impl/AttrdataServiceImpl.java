package com.fh.dianshang.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.dianshang.dao.AttrdataDao;

import com.fh.dianshang.dao.SpDao;
import com.fh.dianshang.entity.po.Attrdatas;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.service.AttrdataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cyl
 * @create 2021-01-20 19:33
 */
@Service
public class AttrdataServiceImpl implements AttrdataService {
    @Resource
    private AttrdataDao attrdataDao;
    @Resource
    private SpDao spDao;
    @Override
    @Transactional   //事务
    public void addAttrdata(ShangPin shangPin, String attr, String sku) {
        //返回主键
        spDao.addSp(shangPin);
        // 声明属性数据的对象
        List<Attrdatas> adList=new ArrayList<>();
        //批量新增
        //将attr的json数组字符串 转为json数组对象
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i <objects.size() ; i++) {
            //构建属性数据对象
            Attrdatas temp=new Attrdatas();
            //设置对应的商品id
            temp.setProId(shangPin.getId());
            temp.setAttrData(objects.get(i).toString());
            //放入集合
            adList.add(temp);
        }
        //将sku的json数组字符串 转为json数组对象
        JSONArray objectssku = JSONObject.parseArray(sku);
        for (int i = 0; i <objectssku.size() ; i++) {
            //得到具体一个json对象
            JSONObject dataJs= (JSONObject) objectssku.get(i);
            //构建属性数据对象
            Attrdatas temp=new Attrdatas();
            //设置对应的商品id
            temp.setProId(shangPin.getId());
            temp.setPrice(dataJs.getDouble("jiage"));
            temp.setStorcks(dataJs.getInteger("kucun"));
            dataJs.remove("jiage");
            dataJs.remove("kucun");
            temp.setAttrData(objectssku.get(i).toString());
            //放入集合
            adList.add(temp);
        }
        //批量新增
        attrdataDao.adds(adList);
    }
}
