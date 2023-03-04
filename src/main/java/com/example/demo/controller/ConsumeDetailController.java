package com.example.demo.controller;

import com.example.demo.entity.ConsumeDetail;
import com.example.demo.service.ConsumeDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumeDetailController {

    @Resource
    ConsumeDetailService consumeDetailService;

    /**
     * 查询钱包消费明细
     * @param wid 钱包id
     * @return
     */
    @GetMapping("/detail/{wid}")
    public List<ConsumeDetail> queryByUid(@PathVariable int wid) {
        List<ConsumeDetail> consumeDetails = null;
        try {
            //todo 涉及分页查询
            consumeDetails = consumeDetailService.queryByWid(wid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consumeDetails;
    }
}
