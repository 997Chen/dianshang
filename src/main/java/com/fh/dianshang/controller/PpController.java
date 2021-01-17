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
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFileUtils.uploadFile(file.getInputStream(),newName));
    }
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
    @PostMapping("addPp")
    public ResultData addPp(PinPai pinPai){
      ppService.addPp(pinPai);
        return ResultData.success("");
    }
    @PostMapping("updatePp")
    public ResultData updatePp(PinPai pinPai){
            if (pinPai.getId()==null){
         return ResultData.error(500,"参数错误");
            }
        ppService.updatePp(pinPai);
     return   ResultData.success("");
    }
}
