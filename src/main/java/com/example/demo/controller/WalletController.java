package com.example.demo.controller;

import com.example.demo.dto.WalletConsumeDTO;
import com.example.demo.dto.WalletRefundDTO;
import com.example.demo.entity.Wallet;
import com.example.demo.service.WalletService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    
    @Resource
    WalletService walletService;

    /**
     * 查询钱包余额
     * @param id 钱包id
     * @return
     */
    @GetMapping("/balance/{id}")
    public BigDecimal queryUserWalletBalance(@PathVariable int id){
        BigDecimal balance = null;
        
        try {
            Wallet wallet = walletService.queryWallet(id);
            balance = wallet.getBalance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return balance;
    }

    /**
     * 消费接口
     * @param walletConsumeDTO
     * @return
     */
    @PostMapping("/consume")
    public void consume(@RequestBody WalletConsumeDTO walletConsumeDTO){
        try {
            walletService.consume(walletConsumeDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 退款接口
     * @param walletRefundDTO
     */
    @PostMapping("/refund")
    public void refund(@RequestBody WalletRefundDTO walletRefundDTO){
        try {
            walletService.refund(walletRefundDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
