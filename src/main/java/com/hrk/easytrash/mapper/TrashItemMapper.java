package com.hrk.easytrash.mapper;

import com.hrk.easytrash.entity.TrashItem;
import com.hrk.easytrash.entity.TrashItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TrashItemMapper {
    long countByExample(TrashItemExample example);

    int deleteByExample(TrashItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrashItem record);

    int insertSelective(TrashItem record);

    List<TrashItem> selectByExample(TrashItemExample example);

    TrashItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrashItem record, @Param("example") TrashItemExample example);

    int updateByExample(@Param("record") TrashItem record, @Param("example") TrashItemExample example);

    int updateByPrimaryKeySelective(TrashItem record);

    int updateByPrimaryKey(TrashItem record);
}