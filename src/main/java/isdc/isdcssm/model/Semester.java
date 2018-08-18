package isdc.isdcssm.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "`cms_semester`")
public class Semester {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`end_date`")
    private Date endDate;

    @Column(name = "`start_date`")
    private Date startDate;

    @Column(name = "`title`")
    private String title;

    private List<Schedule> schedule;

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
     * @return end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
}