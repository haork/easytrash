package com.hrk.easytrash.service;

import com.hrk.easytrash.entity.TrashItem;
import com.hrk.easytrash.entity.TrashItemExample;
import com.hrk.easytrash.mapper.TrashItemMapper;
import com.hrk.easytrash.model.TrashItemEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hrk
 * @Date: 2019-07-04 18:27
 * @Description:
 */
@Service
public class TrashItemService {

    @Resource
    private TrashItemMapper trashItemMapper;

    public TrashItem searchTrash(String name) {
        TrashItemExample example = new TrashItemExample();
        example.createCriteria().andNameEqualTo(name);
        example.setOrderByClause("score desc");
        return trashItemMapper.selectByExample(example).stream().findFirst().orElse(null);
    }

    public int insert(TrashItem trashItem) {
        return trashItemMapper.insertSelective(trashItem);
    }

    public List<TrashItem> selectByName(String name) {
        TrashItemExample example = new TrashItemExample();
        example.createCriteria().andNameLike("%" + name + "%");
        example.setOrderByClause("score desc limit 10");
        return trashItemMapper.selectByExample(example);
    }

    public List<TrashItem> selectByType(Integer typeId) {
        TrashItemExample example = new TrashItemExample();
        example.createCriteria().andTypeIdEqualTo(typeId);
        return trashItemMapper.selectByExample(example);
    }
}
