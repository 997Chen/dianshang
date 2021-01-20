package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.po.ShangPin;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.SpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
    /*1    查询商品数据
    路径   http://192.168.1.107:8080/api/shangpin/querySp
 get请求
  参数  start 必传 size必传
 返回值   {"code":200,"message":"提示",data:""}*/
    @GetMapping("querySp")
    public ResultData querySp(PinPaiData pinPaiData){
        if (pinPaiData.getStart()==null||pinPaiData.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map= spService.querySp(pinPaiData);
        return ResultData.success(map);
    }
    /*2    新增商品数据
    路径   http://192.168.1.107:8080/api/shangpin/addSp
     post请求
      参数  shangPin
     返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("addSp")
    public ResultData addSp(ShangPin shangPin){
        spService.addSp(shangPin);
        return ResultData.success("");
    }
    /*3    删除商品数据
 路径   http://192.168.1.107:8080/api/shangpin/deleteSp
get请求
参数  id 必传
返回值   {"code":200,"message":"提示",data:""}*/
    @GetMapping("deleteSp")
    public ResultData deleteSp(Integer id){
        if (id==null){
            return ResultData.error(500,"参数错误");
        }
         spService.deleteSp(id);
        return ResultData.success("");
    }

}
