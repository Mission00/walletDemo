package com.example.demo.service;


import com.example.demo.dto.WalletConsumeDTO;
import com.example.demo.dto.WalletRefundDTO;
import com.example.demo.entity.Wallet;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public interface WalletService {


    /**
     * 查询钱包详情
     * @param id 钱包id
     * @return 余额
     */
    Wallet queryWallet(int id);

    /**
     * 钱包消费
     */
    void consume(WalletConsumeDTO walletConsumeDTO);
    /**
     * 钱包退款
     */
    void refund(WalletRefundDTO walletRefundDTO);
}
