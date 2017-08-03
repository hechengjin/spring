package com.example.mybatis.mysql.dao.impl;

import com.example.mybatis.mysql.dao.SysUserDao;
import com.example.mybatis.mysql.model.pojo.SysUser;
import com.example.mybatis.mysql.model.pojo.SysUserExample;
import com.example.mybatis.mysql.sqlmapper.custom.SysUserMapperEx;
import com.example.mybatis.mysql.sqlmapper.defaults.SysUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-8-2.
 */
@Repository
public class SysUserDaoImpl implements SysUserDao {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperEx sysUserMapperEx;

    @Override
    public List<SysUser> getList(String username, byte status, Integer pageStart, Integer pageSize) {
        SysUserExample example = getListExample(username, status);
        example.setOrderByClause(" id desc limit " + pageStart + ", " + pageSize);
        return sysUserMapper.selectByExample(example);
    }

    private SysUserExample getListExample(String username, byte status) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(username)) {
            username = "%" + username + "%";
            criteria.andUsernameLike(username);
        }
        if (status != Byte.MAX_VALUE) {
            criteria.andStatusEqualTo(status);
        }
        return example;
    }

    @Override
    public long getListCount(String username, byte status) {
        SysUserExample example = getListExample(username, status);
        return sysUserMapper.countByExample(example);
    }

    @Override
    public long getAllCount(byte status) {
        Map<String, Object> param = new HashMap<>();
        param.put("status", status);
        return sysUserMapperEx.getListCountSql(param);
    }

    @Override
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser getById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int delete(int id) {
        SysUser sysUser = getById(id);
        sysUser.setStatus((byte)1);
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public boolean exist(Integer id, String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusEqualTo((byte)0);
        if (id != null && id > 0) {
            criteria.andIdNotEqualTo(id);
        }
        return sysUserMapper.countByExample(example)>0 ? true : false;
    }
}
