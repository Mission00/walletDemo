package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Wallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WalletDao extends BaseMapper<Wallet> {
    
    @Select("select id,balance from wallet where id = #{id} for update ")
    Wallet selectByIdForUpdate(int id);
}
