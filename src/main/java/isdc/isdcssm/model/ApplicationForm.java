package isdc.isdcssm.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`application_form`")
public class ApplicationForm {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`openid`")
    private String openid;

    @Column(name = "`stu_id`")
    private Long stuId;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`description`")
    private String description;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`gender`")
    private String gender;

    @Column(name = "`introduce`")
    private String introduce;

    @Column(name = "`nationality`")
    private String nationality;

    @Column(name = "`tel`")
    private Long tel;

    @Column(name = "`interview`")
    private Date interview;

    @Column(name = "`block`")
    private Boolean block;

    @Column(name = "`impression_score`")
    private Double impressionScore;

    @Column(name = "`integrated_score`")
    private Double integratedScore;

    @Column(name = "`interviewer`")
    private String interviewer;

    @Column(name = "`judge`")
    private String judge;

    @Column(name = "`pass`")
    private Boolean pass;

    @Column(name = "`reason`")
    private String reason;

    @Column(name = "`tech_score`")
    private Double techScore;

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

    /**
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return stu_id
     */
    public Long getStuId() {
        return stuId;
    }

    /**
     * @param stuId
     */
    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return introduce
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * @param introduce
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return tel
     */
    public Long getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(Long tel) {
        this.tel = tel;
    }

    /**
     * @return interview
     */
    public Date getInterview() {
        return interview;
    }

    /**
     * @param interview
     */
    public void setInterview(Date interview) {
        this.interview = interview;
    }

    /**
     * @return block
     */
    public Boolean getBlock() {
        return block;
    }

    /**
     * @param block
     */
    public void setBlock(Boolean block) {
        this.block = block;
    }

    /**
     * @return impression_score
     */
    public Double getImpressionScore() {
        return impressionScore;
    }

    /**
     * @param impressionScore
     */
    public void setImpressionScore(Double impressionScore) {
        this.impressionScore = impressionScore;
    }

    /**
     * @return integrated_score
     */
    public Double getIntegratedScore() {
        return integratedScore;
    }

    /**
     * @param integratedScore
     */
    public void setIntegratedScore(Double integratedScore) {
        this.integratedScore = integratedScore;
    }

    /**
     * @return interviewer
     */
    public String getInterviewer() {
        return interviewer;
    }

    /**
     * @param interviewer
     */
    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    /**
     * @return judge
     */
    public String getJudge() {
        return judge;
    }

    /**
     * @param judge
     */
    public void setJudge(String judge) {
        this.judge = judge;
    }

    /**
     * @return pass
     */
    public Boolean getPass() {
        return pass;
    }

    /**
     * @param pass
     */
    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    /**
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return tech_score
     */
    public Double getTechScore() {
        return techScore;
    }

    /**
     * @param techScore
     */
    public void setTechScore(Double techScore) {
        this.techScore = techScore;
    }
}