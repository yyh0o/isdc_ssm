package isdc.isdcssm.dao;

import isdc.isdcssm.model.ScoreRequest;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface ScoreRequestDAO extends tk.mybatis.mapper.common.Mapper<ScoreRequest> {
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="complete", property="complete", jdbcType=JdbcType.BIT),
            @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="mm", property="mm", jdbcType=JdbcType.VARCHAR),
            @Result(column="success", property="success", jdbcType=JdbcType.BIT),
            @Result(column="zjh", property="zjh", jdbcType=JdbcType.VARCHAR),
            @Result(column="result", property="result", jdbcType=JdbcType.LONGVARCHAR)
    })
    @Select("select * from service_jwc_score where zjh = #{zjh} and mm = #{mm} and date > #{date} order by date desc limit 1")
    ScoreRequest findRequest(@Param("zjh")String zjh, @Param("mm")String mm, @Param("date")Date date);
}




