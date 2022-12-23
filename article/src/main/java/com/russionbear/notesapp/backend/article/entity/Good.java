package com.russionbear.notesapp.backend.article.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 * 
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */
@TableName("user_info")
@Schema(name = "Good", description = "")
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String userid;

    private String noteid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNoteid() {
        return noteid;
    }

    public void setNoteid(String noteid) {
        this.noteid = noteid;
    }

    @Override
    public String toString() {
        return "Good{" +
        "userid = " + userid +
        ", noteid = " + noteid +
        "}";
    }
}
