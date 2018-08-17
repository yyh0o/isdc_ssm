package isdc.isdcssm.model;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`access_token`")
    private String accessToken;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`enabled`")
    private Boolean enabled;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`user_name`")
    private String userName;

    @Column(name = "`is_root`")
    private Boolean isRoot;

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
     * @return access_token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return is_root
     */
    public Boolean getIsRoot() {
        return isRoot;
    }

    /**
     * @param isRoot
     */
    public void setIsRoot(Boolean isRoot) {
        this.isRoot = isRoot;
    }
}