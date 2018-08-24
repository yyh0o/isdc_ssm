package isdc.isdcssm.dao;

import isdc.isdcssm.model.BlogData;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface BlogDataDAO extends tk.mybatis.mapper.common.Mapper<BlogData> {

    @Delete("delete from blog_data where request_id = #{id}")
    void deleteByRequestID(int id);

    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
            @Result(column="date", property="date", jdbcType=JdbcType.DATE),
            @Result(column="request_id", property="requestId", jdbcType=JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    @Select("select * from blog_data order by date DESC")
    List<BlogData> getAllBlogData();
}




