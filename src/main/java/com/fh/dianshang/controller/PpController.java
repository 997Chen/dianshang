package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.PinPai;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.PpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
