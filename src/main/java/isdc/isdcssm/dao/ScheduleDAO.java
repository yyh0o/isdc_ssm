package isdc.isdcssm.dao;

import isdc.isdcssm.model.Schedule;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ScheduleDAO extends tk.mybatis.mapper.common.Mapper<Schedule> {

    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
            @Result(column="semester_id", property="semesterId", jdbcType=JdbcType.INTEGER),
            @Result(column="id", property="course", many = @Many(select = "isdc.isdcssm.dao.CourseDAO.selectByScheduleId")),
    })
    @Select("select * from user where semester_id = #{semesterId} ")
    List<Schedule> selectBySemesterId(int semesterId);
}




