package isdc.isdcssm.dao;

import isdc.isdcssm.model.Semester;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface SemesterDAO extends tk.mybatis.mapper.common.Mapper<Semester> {
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
            @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="id", property="schedule",many = @Many(select = "isdc.isdcssm.dao.ScheduleDAO.selectBySemesterId")),
    })
    @Select("select * from user where id = #{id} ")
    Semester selectByDate(int id);
}




