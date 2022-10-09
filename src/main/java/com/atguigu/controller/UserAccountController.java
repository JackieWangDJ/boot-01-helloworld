package com.atguigu.controller;

import com.atguigu.bean.UserAccount;
import com.atguigu.mapper.UserAccountMapper;
import com.atguigu.service.UserAccountService;
import com.atguigu.utils.JwtUtil;
import com.atguigu.utils.ReturnData;
import com.atguigu.utils.Token;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class UserAccountController {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/login")
    public ReturnData login (@RequestBody UserAccount userAccount2){
        log.info("userAccount2:"+userAccount2+",");

        QueryWrapper<UserAccount> queryWrapper = new QueryWrapper<UserAccount>();
        Map<String,Object> map = new HashMap<>();
        map.put("username",userAccount2.getUsername());
        map.put("password",userAccount2.getPassword());
        queryWrapper.allEq(map);
        UserAccount userAccount = userAccountService.getOne(queryWrapper);
        log.info(String.valueOf(userAccount));
        ReturnData returnData = new ReturnData<>();
        if (userAccount == null) return returnData.error("203","用户名或密码错误");
        //准备存放在JWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        info.put("id", userAccount.getId());
        info.put("username", userAccount.getUsername());
        info.put("nickname", userAccount.getNickname());
        info.put("avatar", userAccount.getAvatar());
        info.put("birthday", userAccount.getBirthday());
        info.put("sex", userAccount.getSex());
        info.put("age", userAccount.getAge());
        info.put("phone", userAccount.getPhone());
        info.put("email", userAccount.getEmail());
        info.put("createTime", userAccount.getCreateTime());
        info.put("updateTime", userAccount.getUpdateTime());

        //生成JWT字符串
        Token token = new Token(JwtUtil.sign(userAccount.getId(), info));

        return returnData.succeed(token);
    }

    @PostMapping("/register")
    public ReturnData register(){
        UserAccount userAccount = new UserAccount();
        userAccount.setId(UUID.randomUUID().toString());
        ReturnData returnData = new ReturnData();
        return returnData;
    }
    @GetMapping("/getAllUser")
    public ReturnData getAllUser () {
        List<UserAccount> userAccountList = userAccountMapper.selectList(null);
        ReturnData<List<UserAccount>> returnData = new ReturnData<>();
        return returnData.succeed(userAccountList);
    }
}
