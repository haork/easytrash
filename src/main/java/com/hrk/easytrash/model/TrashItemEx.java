package com.hrk.easytrash.model;

import com.hrk.easytrash.entity.TrashItem;

/**
 * @Author: hrk
 * @Date: 2019-07-04 20:54
 * @Description:
 */
public class TrashItemEx extends TrashItem {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
