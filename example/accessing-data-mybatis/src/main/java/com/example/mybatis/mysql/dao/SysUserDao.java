package com.example.mybatis.mysql.dao;

import com.example.mybatis.mysql.model.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-8-2.
 */
public interface SysUserDao {
    List<SysUser> getList(String username, byte status, Integer pageStart, Integer pageSize);
    long getListCount(String username, byte status);
    long getAllCount(byte status);
    int insert(SysUser sysUser);
    SysUser getById(Integer id);
    int update(SysUser sysUser);
    int delete(int id);
    boolean exist(Integer id, String username);

}
