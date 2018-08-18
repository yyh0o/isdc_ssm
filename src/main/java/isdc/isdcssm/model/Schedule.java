package isdc.isdcssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "`cms_schedule`")
public class Schedule {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`target`")
    private String target;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Semester.class)
    @JoinColumn(name = "semester_id")
    private Semester semester;

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
     * @return target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }


}