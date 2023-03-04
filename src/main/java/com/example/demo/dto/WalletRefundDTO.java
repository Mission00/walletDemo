package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletRefundDTO {
    /**
     * 钱包id
     */
    private Integer walletId;

    private Integer orderId;

    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal amount;

    private Integer type;

    private String remark;
}
