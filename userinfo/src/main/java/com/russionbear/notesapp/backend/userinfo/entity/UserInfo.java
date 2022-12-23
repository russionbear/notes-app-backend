package com.russionbear.notesapp.backend.userinfo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */
@Data
@TableName("user_info")
@Schema(name = "UserInfo", description = "")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String email;

    private String username;

    //@TableField(select = false)
//    @Transient
    @JsonIgnore
    private String password;

    private String role;

    @TableLogic
    private int drop;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
        "userid = " + userid +
        ", email = " + email +
        ", username = " + username +
//        ", password = " + password +
        ", role = " + role +
        "}";
    }
}
