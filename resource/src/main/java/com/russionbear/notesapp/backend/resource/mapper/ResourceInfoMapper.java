package com.russionbear.notesapp.backend.resource.mapper;

import com.russionbear.notesapp.backend.resource.entity.ResourceInfo;
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
public interface ResourceInfoMapper extends BaseMapper<ResourceInfo> {



    @Update("update resource_info set `value` = #{content} where noteid = #{noteid} and `name` = #{name}")
    public int updateOne(byte[] content, String noteid, String name);

//    @Insert("insert into resource_info(noteid, `name`, `type`, createTime) " +
//            "value(#{noteid}, #{name}, #{type}, #{createTime})")
//    public int uploadEmptyData(ResourceInfo resourceInfo);

    @Insert("insert into resource_info(noteid, `name`, `type`, `value`, createTime) " +
            "value(#{noteid}, #{name}, #{type}, #{value}, #{createTime})")
    public int uploadData(ResourceInfo resourceInfo);

    //
    @Select("select `n`.`bookname`, `n`.`notename`, `u`.`username`, `r`.`noteid` as `noteid`, `r`.`name` as `name`, `r`.`type` as `type`, `r`.`createTime` as `createTime`, null as `value` from resource_info as `r`, note_info as `n`, user_info as `u`" +
            "where `r`.`noteid` = `n`.`noteid` and `n`.`userid` = `u`.`userid` and" +
            "`r`.`noteid` = #{noteid} and `r`.`name` = #{name}")
    public ResourceInfo getOneInfo(String noteid, String name);

    @Select("select `n`.`bookname`, `n`.`notename`, `u`.`username`, `r`.`noteid` as `noteid`, `r`.`name` as `name`, `r`.`type` as `type`, `r`.`createTime` as `createTime`, null as `value` from resource_info as `r`, note_info as `n`, user_info as `u`" +
            "where `r`.`noteid` = `n`.`noteid` and `n`.`userid` = `u`.`userid` and `r`.`noteid` = #{noteid}")
    public List<ResourceInfo> getAllInfo(String noteid);

    @Select("select `value` from resource_info where `noteid` = (" +
            "select noteid from note_info where bookname = #{bookname} and notename = #{notename} and userid = (" +
            "select userid from user_info where username = #{username}" +
            ")" +
            ") and `name` = #{name}")
    public byte[] getResourceByName(String username, String bookname,String notename, String name);

    @Select("select * from resource_info where `noteid` = (" +
            "select noteid from note_info where bookname = #{bookname} and notename = #{notename} and userid = (" +
            "select userid from user_info where username = #{username}" +
            ")" +
            ") and `name` = #{name}")
    public ResourceInfo getResourceByName2(String username, String bookname,String notename, String name);

    @Select("select `value` from resource_info where `noteid` = #{noteid} and `name` = #{name}")
    public byte[] getResource(String noteid, String name);

    @Update("update resource_info set `name` = #{newname} where `noteid` = #{noteid} and `name` = #{oldname}")
    public int rename(String noteid, String oldname, String newname);

    @Delete("delete from resource_info where `noteid` = #{noteid} and `name` = #{name}")
    public int deleteOne(String noteid, String name);

    @Delete("delete from resource_info where `noteid` = #{noteid}")
    public int deleteByArticle(String ntoeid);

    @Delete("delete from resource_info where `noteid` in (select noteid from note_info where userid = #{userid})")
    public int deleteByUser(String userid);

    @Select("select username from user_info where userid = #{userid}")
    public String getUserNameById(String userid);

//    @Select("select noteid from note_info where notename = #{notename}")
//    public String getNoteIdByName(String ,String notename);
}
