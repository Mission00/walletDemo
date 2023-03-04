package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.ConsumeDetail;

import java.util.List;

public interface ConsumeDetailService extends IService<ConsumeDetail> {

    /**
     * 查询消费明细列表
     * @param wid 用户id
     * @return
     */
    List<ConsumeDetail> queryByWid(int wid);
}
