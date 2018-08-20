package isdc.isdcssm.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`service_jwc_score`")
public class ScoreRequest {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`complete`")
    private Boolean complete;

    @Column(name = "`date`")
    private Date date;

    @Column(name = "`mm`")
    private String mm;

    @Column(name = "`success`")
    private Boolean success;

    @Column(name = "`zjh`")
    private String zjh;

    @Column(name = "`result`")
    private String result;

    public ScoreRequest(String zjh, String mm) {
        this.zjh = zjh;
        this.mm = mm;
    }
    public ScoreRequest() {
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
     * @return complete
     */
    public Boolean getComplete() {
        return complete;
    }

    /**
     * @param complete
     */
    public void setComplete(Boolean complete) {
        this.complete = complete;
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
     * @return mm
     */
    public String getMm() {
        return mm;
    }

    /**
     * @param mm
     */
    public void setMm(String mm) {
        this.mm = mm;
    }

    /**
     * @return success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * @return zjh
     */
    public String getZjh() {
        return zjh;
    }

    /**
     * @param zjh
     */
    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}