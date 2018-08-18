package isdc.isdcssm.dao;

import isdc.isdcssm.model.Course;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface CourseDAO extends tk.mybatis.mapper.common.Mapper<Course> {
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="date", property="date", jdbcType=JdbcType.DATE),
            @Result(column="time_end", property="timeEnd", jdbcType=JdbcType.TIME),
            @Result(column="host", property="host", jdbcType=JdbcType.VARCHAR),
            @Result(column="time_start", property="timeStart", jdbcType=JdbcType.TIME),
            @Result(column="week", property="week", jdbcType=JdbcType.VARCHAR),
            @Result(column="schedule_id", property="scheduleId", jdbcType=JdbcType.INTEGER),
            @Result(column="schedule_id", property="schedule",many = @Many(select = "isdc.isdcssm.dao.FileDAO.selectByCourseId"))
    })
    List<Course> selectByScheduleId(int scheduleId);
}




