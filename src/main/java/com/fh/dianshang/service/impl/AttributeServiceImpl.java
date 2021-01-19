package com.fh.dianshang.service.impl;

import com.fh.dianshang.dao.AttributeDao;
import com.fh.dianshang.dao.ValDao;
import com.fh.dianshang.entity.po.Attribute;
import com.fh.dianshang.entity.po.Val;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-14 20:13
 */
@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeDao attributeDao;
    @Resource
    private ValDao valDao;
    @Override
    public Map queryAttributeData(PinPaiData pinPaiData) {
        Map map = new HashMap();
        Integer count = attributeDao.queryDataCount(pinPaiData);
        List<Attribute> st = attributeDao.queryAttributeData(pinPaiData);
        map.put("count",count);
        map.put("list",st);
        return map;
    }
    @Override
    public void addAttribute(Attribute attribute) {
        attributeDao.addAttribute(attribute);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        attributeDao.updateAttribute(attribute);
    }

    @Override
    public void deleteAttributeById(Integer id) {
        attributeDao.deleteAttributeById(id);
    }

    @Override
    public Map queryDataByTypeId(Integer typeId) {
        Map map=new HashMap();
        ArrayList<Attribute> isSKUData = new ArrayList<>();
        ArrayList<Attribute> NoIsSKUData = new ArrayList<>();
       ArrayList<Val> valSKUList = new ArrayList<>();
        ArrayList<Val> NovalSKUList = new ArrayList<>();
        List<Attribute> attributeList= attributeDao.queryDataByTypeId(typeId);
        for (int i = 0; i <attributeList.size() ; i++) {
              if (attributeList.get(i).getIsSKU()==1){
                  isSKUData.add(attributeList.get(i));
              }else{
                  NoIsSKUData.add(attributeList.get(i));
              }
        }
        map.put("attributeList",attributeList);
        map.put("isSKUData",isSKUData);
        map.put("NoIsSKUData",NoIsSKUData);
     /*
      for (int i = 0; i <isSKUData.size() ; i++) {
            List<Val>  valSKUList2=valDao.getvalDataById(isSKUData.get(i).getId());
        }
       // map.put("valSKUList",valSKUList);
        for (int i = 0; i <NoIsSKUData.size() ; i++) {
            List<Val>   NovalSKUList2 = valDao.getvalDataById(NoIsSKUData.get(i).getId());
        }
        map.put("NovalSKUList",NovalSKUList);*/
       /* map.put("valSKUList",valSKUList);
        map.put("NovalSKUList",NovalSKUList);
        */
        return map;
    }

}
