package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.Val;
import com.fh.dianshang.entity.vo.PinPaiData;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.ValService;
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

    @GetMapping("queryvalDataById")
    public ResultData queryvalDataById(PinPaiData pinPaiData){
        if (pinPaiData.getId()==null||pinPaiData.getStart()==null || pinPaiData.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=  valService.queryvalDataById(pinPaiData);
        return ResultData.success(map);
    }

}
