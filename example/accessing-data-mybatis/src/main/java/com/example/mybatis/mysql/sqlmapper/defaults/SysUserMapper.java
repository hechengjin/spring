package com.example.mybatis.mysql.sqlmapper.defaults;

import com.example.mybatis.mysql.model.pojo.SysUser;
import com.example.mybatis.mysql.model.pojo.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_user (username, password, ",
        "nickname, status, ",
        "descinfo, create_time, ",
        "modify_time)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{descinfo,jdbcType=VARCHAR}, #{createTime,jdbcType=BIGINT}, ",
        "#{modifyTime,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    @Select({
        "select",
        "id, username, password, nickname, status, descinfo, create_time, modify_time",
        "from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.example.mybatis.mysql.sqlmapper.defaults.SysUserMapper.BaseResultMap")
    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    @Update({
        "update sys_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "descinfo = #{descinfo,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "modify_time = #{modifyTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysUser record);
}