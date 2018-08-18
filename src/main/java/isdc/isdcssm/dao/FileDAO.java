package isdc.isdcssm.dao;

import isdc.isdcssm.model.File;
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
public interface FileDAO extends tk.mybatis.mapper.common.Mapper<File> {
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER)
    })
    @Select("select * from cms_file where course_id = #{courseId}")
    List<File> selectByCourseId(int courseId);
}




