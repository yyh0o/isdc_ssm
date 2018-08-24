package isdc.isdcssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`blog_data`")
public class BlogData {
    @Id
    @Column(name = "`id`")
    @JsonIgnore
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`url`")
    private String url;

    @Column(name = "`date`")
    private Date date;

    @JsonIgnore
    @Column(name = "`request_id`")
    private Integer requestId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return request_id
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }


}