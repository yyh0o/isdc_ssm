package isdc.isdcssm.dao;

import isdc.isdcssm.model.ApplicationForm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface ApplicationFormDAO extends tk.mybatis.mapper.common.Mapper<ApplicationForm> {

    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="stu_id", property="stuId", jdbcType=JdbcType.BIGINT),
            @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
            @Result(column="nationality", property="nationality", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.BIGINT),
            @Result(column="interview", property="interview", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="block", property="block", jdbcType=JdbcType.BIT),
            @Result(column="impression_score", property="impressionScore", jdbcType=JdbcType.DOUBLE),
            @Result(column="integrated_score", property="integratedScore", jdbcType=JdbcType.DOUBLE),
            @Result(column="interviewer", property="interviewer", jdbcType=JdbcType.VARCHAR),
            @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
            @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
            @Result(column="tech_score", property="techScore", jdbcType=JdbcType.DOUBLE),
            @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="introduce", property="introduce", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="judge", property="judge", jdbcType=JdbcType.LONGVARCHAR)
    })
    @Select("select * from application_form where openid = #{openid}")
    ApplicationForm queryByOpenid(@Param("openid")String openid);

    @Select("select * from application_form")
    List<ApplicationForm> findAll();
}




