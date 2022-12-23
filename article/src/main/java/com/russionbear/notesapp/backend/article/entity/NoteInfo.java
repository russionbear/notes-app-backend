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
@TableName("note_info")
@Schema(name = "NoteInfo", description = "")
public class NoteInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;


    @TableField(exist = false)
    private String goods;


    @TableField(exist = false)
    private String collections;

    @TableField(exist = false)
    private String username;

    private String noteid;

    private String bookname;

    private String notename;

    private Integer updateTime;

    private Byte isPublic;

    private String content;

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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Byte isPublic) {
        this.isPublic = isPublic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NoteInfo{" +
        "userid = " + userid +
        ", noteid = " + noteid +
        ", bookname = " + bookname +
        ", notename = " + notename +
        ", updateTime = " + updateTime +
        ", isPublic = " + isPublic +
        ", content = " + content +
        "}";
    }
}
