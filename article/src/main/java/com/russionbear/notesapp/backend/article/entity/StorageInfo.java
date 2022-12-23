package com.russionbear.notesapp.backend.article.entity;

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
@TableName("storage_info")
@Schema(name = "StorageInfo", description = "")
public class StorageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookname;

    private String userid;

    @TableField(exist = false)
    public String username;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "StorageInfo{" +
        "bookname = " + bookname +
        ", userid = " + userid +
        "}";
    }
}
