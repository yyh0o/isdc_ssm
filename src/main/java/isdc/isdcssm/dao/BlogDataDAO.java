package isdc.isdcssm.dao;

import isdc.isdcssm.model.BlogData;
import isdc.isdcssm.model.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
}




