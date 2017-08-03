package com.example.mybatis.mysql.model.custom;

import com.example.common.annotation.NotNull;

/**
 * Created by hechengjin on 17-8-2.
 */
public class QueryRequestBody {
    private String name;
    @NotNull
    private byte status;
    @NotNull
    private Integer pageStart;
    @NotNull
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
