package isdc.isdcssm.dao;

import isdc.isdcssm.model.Semester;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

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
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="id", property="schedule",many = @Many(select = "isdc.isdcssm.dao.ScheduleDAO.selectBySemesterId")),
    })

    @Select("select * from cms_semester where id = #{id} ")
    Semester selectByDate(int id);
}




