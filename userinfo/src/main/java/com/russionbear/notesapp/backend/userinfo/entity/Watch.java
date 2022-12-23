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
@TableName("watch")
@Schema(name = "Watch", description = "")
public class Watch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    @TableField(exist = false)
    private String targetname;
    private String targetid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTargetid() {
        return targetid;
    }

    public void setTargetid(String targetid) {
        this.targetid = targetid;
    }

    @Override
    public String toString() {
        return "Watch{" +
        "userid = " + userid +
        ", targetid = " + targetid +
        "}";
    }
}
