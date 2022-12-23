package com.russionbear.notesapp.backend.article.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("discuss")
@Schema(name = "Discuss", description = "")
public class Discuss implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String noteid;

    @TableField(exist = false)
    private String username;

    private Integer createTime;

    private String value;

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

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Discuss{" +
        "userid = " + userid +
        ", noteid = " + noteid +
        ", createTime = " + createTime +
        ", value = " + value +
        "}";
    }
}
