package com.atguigu.service.impl;


import com.atguigu.bean.KnowageUser;
import com.atguigu.mapper.KnowageUserMapper;
import com.atguigu.service.KnowageUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service("knowageUserService")
public class KnowageUserServiceImpl extends ServiceImpl<KnowageUserMapper, KnowageUser> implements KnowageUserService {

}
