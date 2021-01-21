package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.Attrdatas;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.AttrdataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cyl
 * @create 2021-01-20 19:31
 */
@RequestMapping("api/attrdatas")
@CrossOrigin
@RestController
public class AttrdataController {
    @Resource
    private AttrdataService attrdataService;
    @PostMapping("addAttrdata")
    public ResultData addAttrdata(ShangPin shangPin, String attr, String sku){
        attrdataService.addAttrdata(shangPin,attr,sku);
        return ResultData.success("");
    }


}
