package isdc.isdcssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "`cms_course`")
public class Course {
    @Transient
    @JsonIgnore
    private static SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
    @Transient
    @JsonIgnore
    private static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`date`")
    private Date courseDate;

    @DateTimeFormat(pattern="HH:mm")
    @Column(name = "`time_end`")
    private Date endTime;

    @Column(name = "`host`")
    private String host;

    @DateTimeFormat(pattern="HH:mm")
    @Column(name = "`time_start`")
    private Date startTime;

    @Column(name = "`week`")
    private String week;

    @JsonIgnore
    @Column(name = "`schedule_id`")
    private Integer scheduleId;
    @Transient
    private List<File> files;

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getTime() {
        return formatTime.format(startTime) + "-" + formatTime.format(endTime);
    }

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
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }


    /**
     * @return week
     */
    public String getWeek() {
        return week;
    }

    /**
     * @param week
     */
    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * @return schedule_id
     */
    public Integer getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId
     */
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public static SimpleDateFormat getFormatTime() {
        return formatTime;
    }

    public static void setFormatTime(SimpleDateFormat formatTime) {
        Course.formatTime = formatTime;
    }

    public static SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    public static void setFormatDate(SimpleDateFormat formatDate) {
        Course.formatDate = formatDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public String getDate() {
        return formatDate.format(courseDate);
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }
}