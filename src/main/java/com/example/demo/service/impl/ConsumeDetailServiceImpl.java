package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.ConsumeDetailDao;
import com.example.demo.entity.ConsumeDetail;
import com.example.demo.service.ConsumeDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ConsumeDetailServiceImpl extends ServiceImpl<ConsumeDetailDao,ConsumeDetail> implements ConsumeDetailService {
    
    @Resource
    ConsumeDetailDao consumeDetailDao;
    
    public List<ConsumeDetail> queryByWid(int wid){
        QueryWrapper<ConsumeDetail> consumeDetailQueryWrapper = new QueryWrapper<>();
        consumeDetailQueryWrapper.eq("wallet_id",wid);
        return consumeDetailDao.selectList(consumeDetailQueryWrapper);
    }
}
