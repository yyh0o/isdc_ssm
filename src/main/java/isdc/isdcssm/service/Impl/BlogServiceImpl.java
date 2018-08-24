package isdc.isdcssm.service.Impl;

import com.alibaba.fastjson.JSON;
import isdc.isdcssm.dao.BlogDAO;
import isdc.isdcssm.dao.BlogDataDAO;
import isdc.isdcssm.dto.Request.BlogRequest;
import isdc.isdcssm.model.Blog;
import isdc.isdcssm.model.BlogData;
import isdc.isdcssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private final BlogDAO blogDAO;
    private final BlogDataDAO blogDataDAO;

    @Autowired
    BlogServiceImpl(BlogDAO blogDAO, BlogDataDAO blogDataDAO) {
        this.blogDAO = blogDAO;
        this.blogDataDAO = blogDataDAO;
    }

    @Override
    public void updateBlogData()  {
        List<Blog> blogs = blogDAO.selectAll();
        for (Blog blog : blogs) {
            if (new Date().getTime() - blog.getUpdateTimestamp().getTime() > 86400000) {

                try {
                    String content = readDataFromUrl(blog.getUrl());
                    BlogRequest r = JSON.parseObject(content, BlogRequest.class);
                    if (blog.getUpdateTimestamp() == null || (r.getTimestamp().getTime() > blog.getUpdateTimestamp().getTime() && r.getArray().size() > 0)) {
                        r.setBlogRequestID(blog.getId());
                        blogDataDAO.deleteByRequestID(blog.getId());
                        for (BlogData blogData : r.getArray()) {
                            if (blogData.getUrl() != null)
                                blogDataDAO.insert(blogData);
                        }
                        blog.setUpdateTimestamp(new Date());
                        blogDAO.updateByPrimaryKey(blog);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<BlogData> getAll() {
        return blogDataDAO.selectAll();
    }

    private String readDataFromUrl(String url)  {
            String result = "";
            try {
                URL path = new URL(url);
                InputStream is = path.openStream();
                InputStreamReader isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();
                while (data != null) {
                    result += data;
                    System.out.println(data);
                    data = br.readLine();
                }
                br.close();
                isr.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return result;
    }

}
