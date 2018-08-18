package isdc.isdcssm.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`cms_course`")
public class Course {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`date`")
    private Date date;

    @Column(name = "`time_end`")
    private Date timeEnd;

    @Column(name = "`host`")
    private String host;

    @Column(name = "`time_start`")
    private Date timeStart;

    @Column(name = "`week`")
    private String week;

    @Column(name = "`schedule_id`")
    private Integer scheduleId;

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
     * @return time_end
     */
    public Date getTimeEnd() {
        return timeEnd;
    }

    /**
     * @param timeEnd
     */
    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
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
     * @return time_start
     */
    public Date getTimeStart() {
        return timeStart;
    }

    /**
     * @param timeStart
     */
    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
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
}