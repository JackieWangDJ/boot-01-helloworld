package com.atguigu.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString// toString 方法
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
@Data//getter、setter方法
@TableName("user_account")
public class UserAccount {
    @TableId
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private Date birthday;
    private Integer sex;
    private Integer age;
    private String phone;
    private String email;
    private Date createTime;
    private Date updateTime;
}
