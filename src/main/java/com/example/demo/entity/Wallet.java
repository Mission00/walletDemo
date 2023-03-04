package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("wallet")
@ToString
public class Wallet {
    @TableId
    private Integer id;
    
    @TableField("user_id")
    private Integer user_Id;

    @TableField("name")
    private String name;
    
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createTime;
    
    @TableField("modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date modifyTime;
    
    @TableField("balance")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal balance;
}
