package isdc.isdcssm.model;

import javax.persistence.*;

@Table(name = "`index_banner`")
public class Banner {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`action`")
    private String action;

    @Column(name = "`detail`")
    private String detail;

    @Column(name = "`href`")
    private String href;

    @Column(name = "`background_pic`")
    private String backgroundPic;

    @Column(name = "`piority`")
    private Integer piority;

    @Column(name = "`router_link`")
    private String routerLink;

    @Column(name = "`title`")
    private String title;

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
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
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
     * @return background_pic
     */
    public String getBackgroundPic() {
        return backgroundPic;
    }

    /**
     * @param backgroundPic
     */
    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    /**
     * @return piority
     */
    public Integer getPiority() {
        return piority;
    }

    /**
     * @param piority
     */
    public void setPiority(Integer piority) {
        this.piority = piority;
    }

    /**
     * @return router_link
     */
    public String getRouterLink() {
        return routerLink;
    }

    /**
     * @param routerLink
     */
    public void setRouterLink(String routerLink) {
        this.routerLink = routerLink;
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