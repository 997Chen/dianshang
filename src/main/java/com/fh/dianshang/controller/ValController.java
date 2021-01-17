package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.Val;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.ValService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-17 19:16
 */
@CrossOrigin
@RequestMapping("api/val")
@RestController
public class ValController {
    @Resource
    private ValService valService;
    /*1    根据id查询所有的属性值数据
        路径   http://192.168.1.107:8080/api/val/queryvalDataById
        get请求
         参数   id（必传）  start（必传）   size（必传）
        返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @GetMapping("queryvalDataById")
    public ResultData queryvalDataById(PinPaiData pinPaiData){
        if (pinPaiData.getId()==null||pinPaiData.getStart()==null || pinPaiData.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=  valService.queryvalDataById(pinPaiData);
        return ResultData.success(map);
    }
    /*2   新增属性值数据
        路径   http://192.168.1.107:8080/api/val/addVal
        post请求
         参数   val对象（vname，vnameCH，attrId）
        返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("addVal")
    public ResultData addVal(Val val){
      valService.addVal(val);
        return ResultData.success("");
    }
    /*3   根据id删除属性值数据
        路径   http://192.168.1.107:8080/api/val/delValById
        post请求
         参数   id
        返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("delValById")
    public ResultData delValById(Integer id){
        valService.delValById(id);
        return ResultData.success("");
    }
    /*3   根据id修改属性值数据
    路径   http://192.168.1.107:8080/api/val/updateVal
    post请求
     参数   val对象（vname，vnameCH）
    返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("updateVal")
    public ResultData updateVal(Val val){
        valService.updateVal(val);
        return ResultData.success("");
    }

}
