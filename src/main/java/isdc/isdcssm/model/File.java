package isdc.isdcssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "`cms_file`")
public class File {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`href`")
    private String href;

    @Column(name = "`name`")
    private String name;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;

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
     * @return href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


}