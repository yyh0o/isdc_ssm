package isdc.isdcssm.dao;

import isdc.isdcssm.model.Semester;
import isdc.isdcssm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface SemesterDAO extends tk.mybatis.mapper.common.Mapper<Semester> {

    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
            @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    @Select("select * from user where start_date > #{date} and end_date < #{date}")
    Semester selectByDate(Date date);
}




