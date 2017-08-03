package com.example.myproject.controller.web;

import com.example.common.constant.APIConstant;
import com.example.common.model.ErrorMessage;
import com.example.common.model.Result;
import com.example.mybatis.mysql.model.custom.OtherQueryResult;
import com.example.mybatis.mysql.model.custom.OtherRequestBody;
import com.example.mybatis.mysql.model.custom.QueryRequestBody;
import com.example.mybatis.mysql.model.custom.SysUserQueryResult;
import com.example.mybatis.mysql.model.pojo.SysUser;
import com.example.myproject.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-8-2.
 */
@RestController
@RequestMapping(value = "/web/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = APIConstant.MEDIA_TYPE_APPLICATION_JSON)
    public Result<SysUserQueryResult> search(@RequestBody QueryRequestBody queryRequestBody) throws Exception{
        return sysUserService.getList(queryRequestBody);
    }

    @RequestMapping(value = "/allcount", method = RequestMethod.POST, produces = APIConstant.MEDIA_TYPE_APPLICATION_JSON)
    public Result<SysUserQueryResult> allcount(@RequestBody QueryRequestBody queryRequestBody) throws Exception{
        return sysUserService.getAllCount(queryRequestBody);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = APIConstant.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody SysUser sysUser) throws Exception{
        return sysUserService.add(sysUser);
    }

    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = APIConstant.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody SysUser sysUser) throws Exception{
        return sysUserService.mod(sysUser);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = APIConstant.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody OtherRequestBody otherRequestBody) throws Exception{
        return sysUserService.del(otherRequestBody);
    }

    @RequestMapping(value = "/exist", method = RequestMethod.POST, produces = APIConstant.MEDIA_TYPE_APPLICATION_JSON)
    public Result<OtherQueryResult> exist(@RequestBody OtherRequestBody otherRequestBody) throws Exception{
        return sysUserService.exist(otherRequestBody);
    }
}
