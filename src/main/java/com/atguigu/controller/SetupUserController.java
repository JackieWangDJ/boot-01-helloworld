package com.atguigu.controller;

import com.atguigu.bean.SetupUser;
import com.atguigu.service.SetupUserService;
import com.atguigu.utils.ReturnData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/setup")
@CrossOrigin(origins = "*")
public class SetupUserController {

    @Autowired
    private SetupUserService setupUserService;
//    根据userID获取用户的体系
    @GetMapping("/getSetupByUserId")
    public ReturnData getSetupByUserId (@RequestParam("userid") String user_id) {
        QueryWrapper<SetupUser> queryWrapper = new QueryWrapper<SetupUser>();
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",user_id.toString());
        queryWrapper.allEq(map);
        List<SetupUser> userList = setupUserService.list(queryWrapper);
        ReturnData<List<SetupUser>> returnData = new ReturnData<>();
        return returnData.succeed(userList);
    }
}
