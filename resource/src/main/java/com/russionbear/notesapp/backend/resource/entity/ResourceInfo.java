package com.russionbear.notesapp.backend.resource.entity;

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
@TableName("resource_info")
@Schema(name = "ResourceInfo", description = "")
public class ResourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String noteid;

    private String name;

    private String type;

    private byte[] value;

    private Integer createTime;

    @TableField(exist = false)
    public String username;

    @TableField(exist = false)
    public String bookname;

    @TableField(exist = false)
    public String notename;

    public String getNoteid() {
        return noteid;
    }

    public void setNoteid(String noteid) {
        this.noteid = noteid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ResourceInfo{" +
        "noteid = " + noteid +
        ", name = " + name +
        ", type = " + type +
        ", value = " + value +
        ", createTime = " + createTime +
        "}";
    }
}
