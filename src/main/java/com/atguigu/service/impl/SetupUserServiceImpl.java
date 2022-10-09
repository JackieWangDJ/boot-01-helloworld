package com.atguigu.service.impl;


import com.atguigu.bean.SetupUser;
import com.atguigu.mapper.SetupUserMapper;
import com.atguigu.service.SetupUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("setupUserService")
public class SetupUserServiceImpl extends ServiceImpl<SetupUserMapper, SetupUser> implements SetupUserService {
}
