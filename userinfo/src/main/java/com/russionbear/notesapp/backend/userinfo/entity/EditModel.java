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
 * @since 2022-12-16
 */
@TableName("edit_model")
@Schema(name = "EditModel", description = "")
public class EditModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String name;

    private String dsc;

    private String value;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EditModel{" +
        "userid = " + userid +
        ", name = " + name +
        ", dsc = " + dsc +
        ", value = " + value +
        "}";
    }
}
