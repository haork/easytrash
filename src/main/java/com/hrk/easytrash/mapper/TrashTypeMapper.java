package com.hrk.easytrash.mapper;

import com.hrk.easytrash.entity.TrashType;
import com.hrk.easytrash.entity.TrashTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TrashTypeMapper {
    long countByExample(TrashTypeExample example);

    int deleteByExample(TrashTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrashType record);

    int insertSelective(TrashType record);

    List<TrashType> selectByExample(TrashTypeExample example);

    TrashType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrashType record, @Param("example") TrashTypeExample example);

    int updateByExample(@Param("record") TrashType record, @Param("example") TrashTypeExample example);

    int updateByPrimaryKeySelective(TrashType record);

    int updateByPrimaryKey(TrashType record);
}