package com.hrk.easytrash.service;

import com.hrk.easytrash.entity.TrashType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * @Author: hrk
 * @Date: 2019-07-15 13:21
 * @Description:
 */
public class BaiduServiceTest {

    @Test
    public void searchTrash() {

        TrashType trashType = new TrashType();
        trashType.setName("不卡垃圾");

        List<TrashType> list = new ArrayList<>();
        list.add(trashType);

    }





}