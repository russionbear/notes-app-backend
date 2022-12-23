package com.russionbear.notesapp.backend.userinfo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 * 
 * </p>
 *
 * @author russionbear
 * @since 2022-12-17
 */
@TableName("token_info")
@Schema(name = "TokenInfo", description = "")
public class TokenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    private String userid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
        "token = " + token +
        ", userid = " + userid +
        "}";
    }
}
