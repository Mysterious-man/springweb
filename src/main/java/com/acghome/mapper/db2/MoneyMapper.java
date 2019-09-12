package com.acghome.mapper.db2;

import com.acghome.entity.db2.Money;
import com.acghome.entity.db2.MoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyMapper {
    int countByExample(MoneyExample example);

    int deleteByExample(MoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Money record);

    int insertSelective(Money record);

    List<Money> selectByExample(MoneyExample example);

    Money selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Money record, @Param("example") MoneyExample example);

    int updateByExample(@Param("record") Money record, @Param("example") MoneyExample example);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);
}