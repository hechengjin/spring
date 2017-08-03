package com.example.myproject.service;

import com.example.common.model.ErrorMessage;
import com.example.common.model.Result;
import com.example.mybatis.mysql.model.custom.OtherQueryResult;
import com.example.mybatis.mysql.model.custom.OtherRequestBody;
import com.example.mybatis.mysql.model.custom.QueryRequestBody;
import com.example.mybatis.mysql.model.custom.SysUserQueryResult;
import com.example.mybatis.mysql.model.pojo.SysUser;


/**
 * Created by hechengjin on 17-8-2.
 */
public interface SysUserService {
    Result<SysUserQueryResult> getList(QueryRequestBody queryRequestBody);
    Result<SysUserQueryResult> getAllCount(QueryRequestBody queryRequestBody);
    ErrorMessage add(SysUser sysUser);
    ErrorMessage mod(SysUser sysUser);
    ErrorMessage del(OtherRequestBody otherRequestBody);
    Result<OtherQueryResult> exist(OtherRequestBody otherRequestBody);

}
