package com.hrk.easytrash.service;

import com.hrk.easytrash.entity.TrashItem;
import com.hrk.easytrash.entity.TrashType;
import com.hrk.easytrash.mapper.TrashTypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hrk
 * @Date: 2019-07-04 17:59
 * @Description:
 */
@Slf4j
@Service
public class BaiduService {

    @Resource
    private TrashTypeMapper trashTypeMapper;

    public TrashItem searchTrash(String name) {

        List<TrashType> trashTypeList = trashTypeMapper.selectByExample(null);
        if (!trashTypeList.isEmpty()) {

            String url = String.format("http://www.baidu.com/s?wd=%s是什么垃圾&rn=50", name);

            try {
                Document document = Jsoup.connect(url).get();
                String content = document.getElementById("content_left").text();
                log.info(content);
                TrashType resultType = null;
                int score = 0;
                int total = 0;
                for (TrashType type : trashTypeList) {
                    String text = content;
                    int c = 0;
                    while (text.contains(type.getName())) {
                        text = text.replaceFirst(type.getName(), "");
                        c++;
                    }
                    if (c > score) {
                        resultType = type;
                        score = c;
                    }
                    total += c;
                }
                if (score > 2) {
                    TrashItem trashItem = new TrashItem();
                    trashItem.setName(name);
                    trashItem.setAlias(name);
                    trashItem.setTypeId(resultType.getId());
                    trashItem.setScore((double) score / total);
                    return trashItem;
                }
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }
        return null;
    }
}
