package com.atguigu.controller;

import com.atguigu.bean.KnowageUser;
import com.atguigu.mapper.KnowageUserMapper;
import com.atguigu.service.KnowageUserService;
import com.atguigu.utils.ReturnData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/knowage")
@CrossOrigin(origins = "*")
public class KnowageUserController {
    @Autowired
    KnowageUserMapper knowageUserMapper;
    @Autowired
    KnowageUserService knowageUserService;
//    根据userid查询知识
    @GetMapping("/getByUserId")
    public ReturnData getByUserId(@RequestParam("userId") String user_id){
        QueryWrapper<KnowageUser> queryWrapper = new QueryWrapper<KnowageUser>();
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",user_id.toString());
        queryWrapper.allEq(map);
        List<KnowageUser> knowageUserList = knowageUserMapper.selectList(queryWrapper);
        ReturnData<List<KnowageUser>> returnData = new ReturnData();
        return returnData.succeed(knowageUserList);
    }
//    删除知识
    @GetMapping("/removeKnowage")
    public ReturnData removeKnowage (@RequestParam("knowageId")String knowageId) {
        Boolean res = knowageUserService.removeById(knowageId);
        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
        if (res) return returnData.error("203","删除失败");
        return returnData.succeed("200","删除成功");
    }
//    修改知识
//    public ReturnData editKnowage(@RequestParam)
//    增加知识
}
