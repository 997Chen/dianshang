package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.SpService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cyl
 * @create 2021-01-18 18:46
 */
@RestController
@RequestMapping("api/shangpin")
@CrossOrigin
public class SpController {
    @Resource
    public SpService spService;
    /*2    新增属性数据
     post请求
      参数  shangPin
     返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("addSp")
    public ResultData addSp(ShangPin shangPin){
        spService.addSp(shangPin);
        return ResultData.success("");
    }
}
