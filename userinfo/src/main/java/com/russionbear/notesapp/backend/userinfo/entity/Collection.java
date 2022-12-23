package com.russionbear.notesapp.backend.userinfo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("collection")
@Schema(name = "Collection", description = "")
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String username;


    @TableField(exist = false)
    private String bookname;

    @TableField(exist = false)
    private String notename;


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
        return "Collection{" +
        "userid = " + userid +
        ", noteid = " + noteid +
        "}";
    }
}
