package isdc.isdcssm.dao;

import isdc.isdcssm.model.Semester;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.zip.DataFormatException;

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
            @Result(column="end_date", property="semesterEnd", jdbcType=JdbcType.DATE),
            @Result(column="start_date", property="semesterStart", jdbcType=JdbcType.DATE),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="id", property="schedule",many = @Many(select = "isdc.isdcssm.dao.ScheduleDAO.selectBySemesterId")),
    })

    @Select("select * from cms_semester where start_date < #{date} and end_date > #{date}")
    Semester selectByDate(Date date);
}




