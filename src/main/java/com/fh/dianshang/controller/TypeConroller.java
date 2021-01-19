package com.fh.dianshang.controller;

import com.fh.dianshang.entity.po.Type;
import com.fh.dianshang.entity.vo.ResultData;
import com.fh.dianshang.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-12 16:39
 */
@RestController
@CrossOrigin
@RequestMapping("api/type")
public class TypeConroller {
    @Resource
    public TypeService typeService;
/*1    查询所有的分类数据
    路径   http://192.168.1.107:8080/api/type/getData
    get请求
            参数
    返回值   {"code":200,"message":"提示",data:[{*}]}*/
@GetMapping("getData")
    public ResultData getData(){
    List<Type> typeList =typeService.getData();
    return ResultData.success(typeList);
}
    @GetMapping("queryDataByTypeId")
    public ResultData queryDataByTypeId(Integer typeId){
        List<Type> typeList =typeService.getData();
        return ResultData.success(typeList);
    }
/*2    查询指定pid的数据
    路径   http://192.168.1.107:8080/api/type/getDataByPid
    get请求
    参数    Pid
    返回值   {"code":200,"message":"提示",data:[{*}]}*/
@GetMapping("getDataByPid")
public ResultData getDataByPid(Integer pid){
    if (pid==null){
        return ResultData.error(500,"参数错误");
    }
    List<Type> typeList=typeService.getDataByPid(pid);
    return ResultData.success(typeList);
}

/*3  新增分类
    路径   http://192.168.1.107:8080/api/type/add
    post请求
    参数    pid    name
    返回值    {code:"",message:"",data:新增的id}*/
@PostMapping("add")
public ResultData add(Type type){
    if (type.getPid()==null){
        return ResultData.error(500,"参数错误");
    }
    typeService.add(type);
    return ResultData.success(type.getId());
}
    @PostMapping("toUpdate")
    public ResultData toUpdate(Integer id){
        if (id==null){
            return ResultData.error(500,"参数错误");
        }
        Type type=typeService.toUpdate(id);
        return ResultData.success(type);
    }

 /*4   修改
    路径  http://192.168.1.107:8080/api/type/update
    post请求
    参数   id （必传）     pid   name  isDel
    返回值     {code:"",message:""}*/
 @PostMapping("update")
 public ResultData update(Type type){
     if (type.getId()==null){
         return ResultData.error(500,"参数错误");
     }
     typeService.update(type);
     return ResultData.success("");
 }

}
