package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("consume_detail")
public class ConsumeDetail {
    @TableId
    private Integer id;

    @TableField("wallet_id")
    private Integer walletId;
    
    @TableField("create_time")
    private Date createTime;

    @TableField("order_id")
    private Integer orderId;
    
    @TableField("amount")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal amount;
    
    @TableField("type")
    private Integer type;

    @TableField("remark")
    private String remark;
}
