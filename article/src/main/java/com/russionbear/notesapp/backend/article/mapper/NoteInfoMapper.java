package com.russionbear.notesapp.backend.article.mapper;

import com.russionbear.notesapp.backend.article.entity.NoteInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */
@Mapper
public interface NoteInfoMapper extends BaseMapper<NoteInfo> {

    @Select("select " +
            "(select count(`g`.`userid`) from `good` as `g` where `g`.`noteid` = `n`.`noteid`) as `goods`, " +
            "(select count(`c`.`userid`) from `collection` as `c` where `c`.`noteid` = `n`.`noteid`) as `collections`, " +
            "`n`.*, `u`.username as `username`" +
            "from note_info as `n`, user_info as `u` " +
            "where `n`.`userid` =`u`.`userid`  and " +
            "`n`.`noteid` = #{noteid}")
    public NoteInfo getOne(String noteid);

    @Select("select " +
            "(select count(`g`.`userid`) from `good` as `g` where `g`.`noteid` = `n`.`noteid`) as `goods`, " +
            "(select count(`c`.`userid`) from `collection` as `c` where `c`.`noteid` = `n`.`noteid`) as `collections`, " +
            "`n`.*, `u`.username as `username`" +
            "from note_info as `n`, user_info as `u` " +
            "where `n`.`userid` =`u`.`userid`  and " +
            "`n`.`notename` = #{notename} and `u`.`username` = #{username} and `n`.`bookname` = #{bookname}")
    public NoteInfo getOneByFull(String username, String bookname, String notename);

    @Select("select " +
            "(select count(`g`.`userid`) from `good` as `g` where `g`.`noteid` = `n`.`noteid`) as `goods`, " +
            "(select count(`c`.`userid`) from `collection` as `c` where `c`.`noteid` = `n`.`noteid`) as `collections`, " +
            "`n`.*, `u`.username as `username`" +
            "from note_info as `n`, user_info as `u` " +
            "where `n`.`userid` =`u`.`userid`  and " +
            "`n`.`bookname` = #{bookname} and `u`.`username` = #{username}")
    public List<NoteInfo> getAll(String username, String bookname);

    @Select("select " +
            "(select count(`g`.`userid`) from `good` as `g` where `g`.`noteid` = `n`.`noteid`) as `goods`, " +
            "(select count(`c`.`userid`) from `collection` as `c` where `c`.`noteid` = `n`.`noteid`) as `collections`, " +
            "`n`.*, `u`.username as `username`" +
            "from note_info as `n`, user_info as `u` " +
            "where `n`.`userid` =`u`.`userid`  and " +
            "`n`.`notename` like #{kw}")
    public List<NoteInfo> search(String kw);

    @Insert("insert into note_info (userid, bookname, notename, updateTime, isPublic) " +
            "values(#{userid}, #{bookname}, #{notename}, #{updateTime}, #{isPublic})")
    public int insertOne(NoteInfo noteInfo);

    @Insert("insert into resource_info(noteid, `name`, `type`, createTime) " +
            "value(#{noteid}, #{name}, #{type}, #{createTime})")
    public int uploadEmptyResource(String noteid, String name, String type, int createTime);

    @Delete("delete from resource_info where noteid = #{noteid}")
    public int deleteNoteResource(String noteid);


    @Update("update note_info set notename = #{notename} where noteid = #{noteid}")
    public int updateName(String notename, String noteid);

    @Delete("delete from note_info where noteid = #{noteid}")
    public int deleteOne(String noteid);

    @Delete("delete from note_info where bookname = #{bookname} and userid = #{userid}")
    public int deleteByBook(String userid, String bookname);

    @Delete("delete from note_info where userid = #{userid}")
    public int deleteByUser(String userid);
}
