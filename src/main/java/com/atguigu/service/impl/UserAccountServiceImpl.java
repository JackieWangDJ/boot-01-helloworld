package com.atguigu.service.impl;

import com.atguigu.bean.UserAccount;
import com.atguigu.mapper.UserAccountMapper;
import com.atguigu.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("userAccountService")
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {
}
