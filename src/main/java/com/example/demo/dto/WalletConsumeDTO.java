package com.example.demo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletConsumeDTO {
    /**
     * 钱包id
     */
    private Integer id;

    private Integer orderId;

    private Integer walletId;


    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal amount;

    private Integer type;

    private String remark;


}
