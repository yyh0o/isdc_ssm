package isdc.isdcssm.dao;

import isdc.isdcssm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface UserDAO extends tk.mybatis.mapper.common.Mapper<User> {
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="access_token", property="accessToken", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="is_root", property="isRoot", jdbcType=JdbcType.BIT),
            @Result(column="is_member", property="isMember", jdbcType=JdbcType.BIT)
    })
    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);

    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="access_token", property="accessToken", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="is_root", property="isRoot", jdbcType=JdbcType.BIT),
            @Result(column="is_member", property="isMember", jdbcType=JdbcType.BIT)
    })
    @Select("select * from user where access_token = #{accessToken}")
    User selectByAccessToken(String accessToken);
}




