package com.example.mybatis.mysql.model.custom;

import com.example.common.annotation.NotNull;

/**
 * Created by hechengjin on 17-8-2.
 */
public class OtherRequestBody {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
