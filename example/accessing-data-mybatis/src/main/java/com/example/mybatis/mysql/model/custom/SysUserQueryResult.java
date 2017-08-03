package com.example.mybatis.mysql.model.custom;

import com.example.mybatis.mysql.model.pojo.SysUser;

import java.util.List;

/**
 * Created by hechengjin on 17-8-2.
 */
public class SysUserQueryResult {
    private long total = 0;
    List<SysUser> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<SysUser> getDataList() {
        return dataList;
    }

    public void setDataList(List<SysUser> dataList) {
        this.dataList = dataList;
    }
}
