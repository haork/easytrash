package com.hrk.easytrash.controller;

import com.alibaba.fastjson.JSON;
import com.hrk.easytrash.entity.TrashItem;
import com.hrk.easytrash.entity.TrashType;
import com.hrk.easytrash.exception.DefaultExceptionHandler;
import com.hrk.easytrash.model.BaseResponse;
import com.hrk.easytrash.model.TrashItemEx;
import com.hrk.easytrash.service.BaiduService;
import com.hrk.easytrash.service.TrashItemService;
import com.hrk.easytrash.service.TrashTypeService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: hrk
 * @Date: 2019-07-04 16:36
 * @Description:
 */
@Slf4j
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/trash", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TrashController {

    @Resource
    private TrashItemService trashItemService;

    @Resource
    private TrashTypeService trashTypeService;

    @Resource
    private BaiduService baiduService;

    @RequestMapping("/search")
    public BaseResponse search(@RequestParam String q) {
        if (StringUtil.isBlank(q)) {
            return BaseResponse.fail("q is required");
        }
        q = q.trim();

        log.info(q);
        TrashItem item = trashItemService.searchTrash(q);
        if (item == null) {
            item = baiduService.searchTrash(q);
            if (item == null) {
                item = new TrashItem();
                item.setName(q);
                item.setAlias(q);
                item.setScore(1.0);
                item.setTypeId(0);
            } else {
                trashItemService.insert(item);
            }
        }

        log.info(JSON.toJSONString(item));

        TrashType type = trashTypeService.getById(item.getTypeId());
        if (type != null) {
            TrashItemEx itemEx = new TrashItemEx();
            BeanUtils.copyProperties(item, itemEx);
            itemEx.setTypeName(type.getName());
            return BaseResponse.success(itemEx);
        } else {
            return BaseResponse.success(item);
        }
    }

    @RequestMapping("/getSuggest")
    public BaseResponse list(@RequestParam String q) {
        log.info(q);
        List<TrashItem> list = trashItemService.selectByName(q);
        List<String> result = list.stream().map(TrashItem::getName).collect(Collectors.toList());
        log.info(JSON.toJSONString(result));
        return BaseResponse.success(result);
    }

    @RequestMapping("/getListByType")
    public BaseResponse getListByType(@RequestParam Integer typeId) {
        List<TrashItem> list = trashItemService.selectByType(typeId);
        List<String> result = list.stream().map(TrashItem::getName).collect(Collectors.toList());
        return BaseResponse.success(result);
    }

    @RequestMapping("/getTypeList")
    public BaseResponse getTypeList() {
        List<TrashType> list = trashTypeService.getAllType();
        return BaseResponse.success(list);
    }

//    @RequestMapping("/generate")
//    public BaseResponse generate() throws IOException {
//
//        String json = FileUtils.readFileToString(Resources.getResourceAsFile("data.json"));
//
//        List<TrashItemEx> list = JSON.parseArray(json, TrashItemEx.class);
//
//        for (TrashItemEx trashInfo : list) {
//            TrashItem item = new TrashItem();
//            item.setName(trashInfo.getName());
//            item.setAlias(trashInfo.getAlias());
//            item.setDescription(trashInfo.getDesc());
//            item.setTypeId(trashInfo.getType());
//            item.setScore(1.0);
//            trashItemService.insert(item);
//        }
//
//        return BaseResponse.success();
//    }
}
