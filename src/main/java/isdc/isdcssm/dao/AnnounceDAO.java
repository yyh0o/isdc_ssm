package isdc.isdcssm.dao;

import isdc.isdcssm.model.Announce;
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
public interface AnnounceDAO extends tk.mybatis.mapper.common.Mapper<Announce> {
    @Results ({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
        @Result(column = "create_data", property = "create_data", jdbcType = JdbcType.DATE),
        @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR)
    })
    @Select("select * from `announce` WHERE `enabled` = 1 ORDER BY `create_date` desc")
    List<Announce>findAll();
}




