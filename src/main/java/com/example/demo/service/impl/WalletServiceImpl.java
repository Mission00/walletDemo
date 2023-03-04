package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dao.ConsumeDetailDao;
import com.example.demo.dao.WalletDao;
import com.example.demo.dto.WalletConsumeDTO;
import com.example.demo.dto.WalletRefundDTO;
import com.example.demo.entity.ConsumeDetail;
import com.example.demo.entity.Wallet;
import com.example.demo.service.ConsumeDetailService;
import com.example.demo.service.WalletService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;


@Service
public class WalletServiceImpl implements WalletService {
    @Resource
    WalletDao walletDao;

    @Resource
    ConsumeDetailDao consumeDetailDao;

    /**
     * 根据钱包id查询钱包详情
     * @param id 钱包id
     * @return 余额
     */
    @Override
    public Wallet queryWallet(int id){
        Wallet wallet = walletDao.selectById(id);
        if(wallet==null){
            //抛出异常
        }
        return wallet;
    }

    /**
     * 钱包消费
     * @param walletConsumeDTO
     */
    @Transactional
    public void consume(WalletConsumeDTO walletConsumeDTO){

        Wallet wallet = walletDao.selectByIdForUpdate(walletConsumeDTO.getWalletId());
        
        if(wallet==null){
            //抛出钱包不存在异常
        }
        
        BigDecimal newBalance = wallet.getBalance().subtract(walletConsumeDTO.getAmount());
        
        if(newBalance.compareTo(BigDecimal.ZERO)>=0){
            Wallet newWallet = new Wallet();
            //封装新wallet的balance
            newWallet.setBalance(newBalance);
            newWallet.setId(wallet.getId());
            //更新钱包余额
            walletDao.updateById(newWallet);

            //消费明细表增加消费记录
            ConsumeDetail consumeDetail = new ConsumeDetail();
//            consumeDetail.setUserId(wallet.getUser_Id());
            consumeDetail.setWalletId(wallet.getId());
            consumeDetail.setAmount(walletConsumeDTO.getAmount());
            consumeDetail.setCreateTime(new Date());
            consumeDetail.setType(1);
            consumeDetailDao.insert(consumeDetail);
        }else{
            //抛出余额不足异常
        }

    }

    /**
     * 钱包退款
     */
    @Transactional
    public void refund(WalletRefundDTO walletRefundDTO){
        Wallet wallet = walletDao.selectByIdForUpdate(walletRefundDTO.getWalletId());

        if(wallet==null){
            //抛出钱包不存在异常
        }

        BigDecimal newBalance = wallet.getBalance().add(walletRefundDTO.getAmount());
        
        Wallet newWallet = new Wallet();
        //封装新wallet的balance
        newWallet.setBalance(newBalance);
        newWallet.setId(wallet.getId());
        //更新
        walletDao.updateById(newWallet);

        //消费明细表增加消费记录
        ConsumeDetail consumeDetail = new ConsumeDetail();
//        consumeDetail.setUserId(wallet.getUser_Id());
        consumeDetail.setWalletId(wallet.getId());
        consumeDetail.setAmount(walletRefundDTO.getAmount());
        consumeDetail.setCreateTime(new Date());
        consumeDetail.setType(0);
        consumeDetailDao.insert(consumeDetail);

    }
    
}
