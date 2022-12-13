package com.gec.mapper;

import com.gec.pojo.Shopcar;
import com.gec.pojo.ShopcarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopcarMapper {
    int countByExample(ShopcarExample example);

    int deleteByExample(ShopcarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    List<Shopcar> selectByExample(ShopcarExample example);

    Shopcar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByExample(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByPrimaryKeySelective(Shopcar record);

    int updateByPrimaryKey(Shopcar record);
}