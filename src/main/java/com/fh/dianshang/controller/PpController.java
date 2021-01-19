package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.PpService;
import com.fh.dianshang.utils.OssFileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author cyl
 * @create 2021-01-13 18:39
 */
@RestController
@CrossOrigin
@RequestMapping("api/pinpai")
public class PpController {
    @Resource
    private PpService ppService;
    @RequestMapping("uploadFile")
    public ResultData uploadFile(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        Date date = new Date();
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        //存储路径
        newName=sd.format(date)+"/"+newName;
        return ResultData.success(OssFileUtils.uploadFile(file.getInputStream(),newName));
    }
    /*1    查询所有的品牌数据
          路径   http://192.168.1.107:8080/api/pinpai/queryData
          get请求
           参数  size  start  两个参数必传
          返回值   {"code":200,"message":"提示",data:[{*}]}*/
        @GetMapping("queryData")
    public ResultData queryData(PinPaiData pinPaiData){
        if (pinPaiData.getStart()==null){
            return ResultData.error(500,"参数错误");
        }
        if (pinPaiData.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
      Map map=  ppService.queryData(pinPaiData);
        return ResultData.success(map);
    }
    /*1    查询所有的品牌数据
         路径   http://192.168.1.107:8080/api/pinpai/queryData
         get请求
          参数  不传参数
         返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @GetMapping("queryPinpaiData")
    public ResultData queryPinpaiData(){

       List<PinPai> pinpais= ppService.queryPinpaiData();
        return ResultData.success(pinpais);
    }
    /*2    新增的品牌数据
      路径   http://192.168.1.107:8080/api/pinpai/addPp
      post.请求
       参数  Pinpai对象
      返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @PostMapping("addPp")
    public ResultData addPp(PinPai pinPai){
      ppService.addPp(pinPai);
        return ResultData.success("");
    }
    /*3   修改品牌数据
      路径   http://192.168.1.107:8080/api/pinpai/updatePp
      post.请求
       参数  Pinpai对象
      返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @PostMapping("updatePp")
    public ResultData updatePp(PinPai pinPai){
            if (pinPai.getId()==null){
         return ResultData.error(500,"参数错误");
            }
        ppService.updatePp(pinPai);
     return   ResultData.success("");
    }
}
