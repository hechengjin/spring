package com.example.myproject.service.impl;

import com.example.common.constant.APIConstant;
import com.example.common.model.ErrorCode;
import com.example.common.model.ErrorMessage;
import com.example.common.model.Result;
import com.example.common.util.ValidUtils;
import com.example.mybatis.mysql.dao.SysUserDao;
import com.example.mybatis.mysql.model.custom.OtherQueryResult;
import com.example.mybatis.mysql.model.custom.OtherRequestBody;
import com.example.mybatis.mysql.model.custom.QueryRequestBody;
import com.example.mybatis.mysql.model.custom.SysUserQueryResult;
import com.example.mybatis.mysql.model.pojo.SysUser;
import com.example.myproject.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-8-2.
 */
//@Transactional
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    public Result<SysUserQueryResult> getList(QueryRequestBody queryRequestBody) {
        Result<SysUserQueryResult> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(queryRequestBody);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setResult(ex.getMessage());
            return retResult;
        }

        SysUserQueryResult sysUserQueryResult = new SysUserQueryResult();
        long count = sysUserDao.getListCount(queryRequestBody.getName(), queryRequestBody.getStatus());
        sysUserQueryResult.setTotal(count);
        List<SysUser> sysUserList = sysUserDao.getList(queryRequestBody.getName(), queryRequestBody.getStatus(), queryRequestBody.getPageStart(), queryRequestBody.getPageSize());
        sysUserQueryResult.setDataList(sysUserList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setResult(ErrorCode.SUCCESS.getResult());
        retResult.setData(sysUserQueryResult);
        return retResult;
    }

    @Override
    public Result<SysUserQueryResult> getAllCount(QueryRequestBody queryRequestBody) {
        Result<SysUserQueryResult> retResult = new Result<>();
        try {
            ValidUtils.validNotNullEx(queryRequestBody, "status");
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setResult(ex.getMessage());
            return retResult;
        }
        SysUserQueryResult sysUserQueryResult = new SysUserQueryResult();
        long count = sysUserDao.getAllCount(queryRequestBody.getStatus());
        sysUserQueryResult.setTotal(count);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setResult(ErrorCode.SUCCESS.getResult());
        retResult.setData(sysUserQueryResult);
        return retResult;
    }

    public ErrorMessage add(SysUser sysUser) {
        try {
            ValidUtils.validNotNullEx(sysUser, "username,password");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        sysUser.setCreateTime(System.currentTimeMillis());
        sysUser.setModifyTime(System.currentTimeMillis());
        sysUser.setStatus(APIConstant.STATUS_OK);
        int operRes = sysUserDao.insert(sysUser);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    public ErrorMessage mod(SysUser sysUser) {
        try {
            ValidUtils.validNotNullEx(sysUser, "id,username,password");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        sysUser.setModifyTime(System.currentTimeMillis());
        int operRes = sysUserDao.update(sysUser);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    public ErrorMessage del(OtherRequestBody otherRequestBody) {
        try{
            ValidUtils.validNotNullEx(otherRequestBody, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = sysUserDao.delete(otherRequestBody.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    public Result<OtherQueryResult> exist(OtherRequestBody otherRequestBody) {
        Result<OtherQueryResult> retResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(otherRequestBody, "name");
        } catch (Exception ex){
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setResult(ex.getMessage());
            return retResult;
        }

        boolean exist = sysUserDao.exist(otherRequestBody.getId(), otherRequestBody.getName());
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setResult(ErrorCode.SUCCESS.getResult());
        OtherQueryResult otherQueryResult = new OtherQueryResult();
        otherQueryResult.setExist(exist);
        retResult.setData(otherQueryResult);
        return retResult;
    }
}
