package isdc.isdcssm.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "`cms_semester`")
public class Semester {



    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;


    @Column(name = "`end_date`")
    private Date semesterStart;


    @Column(name = "`start_date`")
    private Date semesterEnd;

    @Column(name = "`title`")
    private String title;
    @Transient
    private List<Schedule> schedule;
    @Transient
    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSemesterStart() {
        return semesterStart;
    }

    public void setSemesterStart(Date semesterStart) {
        this.semesterStart = semesterStart;
    }

    public Date getSemesterEnd() {
        return semesterEnd;
    }

    public void setSemesterEnd(Date semesterEnd) {
        this.semesterEnd = semesterEnd;
    }
}