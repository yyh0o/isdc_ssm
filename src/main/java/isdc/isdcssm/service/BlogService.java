package isdc.isdcssm.service;

import isdc.isdcssm.model.BlogData;

import java.net.MalformedURLException;
import java.util.List;

public interface BlogService {

   void updateBlogData() ;
   List<BlogData> getAll();
}
