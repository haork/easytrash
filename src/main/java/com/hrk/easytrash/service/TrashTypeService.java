package com.hrk.easytrash.service;

import com.hrk.easytrash.entity.TrashType;
import com.hrk.easytrash.entity.TrashTypeExample;
import com.hrk.easytrash.mapper.TrashTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hrk
 * @Date: 2019-07-04 22:35
 * @Description:
 */
@Service
public class TrashTypeService {

    @Resource
    private TrashTypeMapper trashTypeMapper;

    public TrashType getById(Integer id) {
        return trashTypeMapper.selectByPrimaryKey(id);
    }

    public List<TrashType> getAllType() {
        return trashTypeMapper.selectByExample(null);
    }
}
