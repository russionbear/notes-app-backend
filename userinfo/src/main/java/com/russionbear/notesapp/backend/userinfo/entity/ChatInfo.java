package com.russionbear.notesapp.backend.userinfo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("chat_info")
@Schema(name = "ChatInfo", description = "")
public class ChatInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    public String sourcename;

    @TableField(exist = false)
    public String username;

    @TableField(exist = false)
    public String targetname;

    private String sourceid;

    private String targetid;

    private Integer createTime;

    private String msg;

    private Byte got;

    private Byte isSys;


    @Override
    public String toString() {
        return "ChatInfo{" +
        "sourceid = " + sourceid +
        ", targetid = " + targetid +
        ", createTime = " + createTime +
        ", msg = " + msg +
        ", got = " + got +
        ", isSys = " + isSys +
        "}";
    }
}
