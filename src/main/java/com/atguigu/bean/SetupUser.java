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
@TableName("setup_user")
public class SetupUser {
    @TableId
    private String id;

    private String userId;
    private String cardColor;
    private String title;
    private String represent;
    private Date createTime;
    private Date updateTime;
}
