package com.acghome.mapper.db1;

import com.acghome.entity.db1.Mall;
import com.acghome.entity.db1.MallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMapper {
    int countByExample(MallExample example);

    int deleteByExample(MallExample example);

    int deleteByPrimaryKey(Integer mallId);

    int insert(Mall record);

    int insertSelective(Mall record);

    List<Mall> selectByExample(MallExample example);

    Mall selectByPrimaryKey(Integer mallId);

    int updateByExampleSelective(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByExample(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByPrimaryKeySelective(Mall record);

    int updateByPrimaryKey(Mall record);
}