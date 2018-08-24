package isdc.isdcssm.dto.Request;

import isdc.isdcssm.model.Blog;
import isdc.isdcssm.model.BlogData;

import java.util.Date;
import java.util.List;

public class BlogRequest {
    private Date timestamp;

    List<BlogData> array;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<BlogData> getArray() {
        return array;
    }

    public void setArray(List<BlogData> array) {
        this.array = array;
    }

    public void setBlogRequestID(int id){
        for(BlogData blogData:array){
            blogData.setRequestId(id);
        }
    }
}
