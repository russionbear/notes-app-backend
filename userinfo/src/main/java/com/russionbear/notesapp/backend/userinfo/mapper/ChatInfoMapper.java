package com.russionbear.notesapp.backend.userinfo.mapper;

import com.russionbear.notesapp.backend.userinfo.entity.ChatInfo;
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
public interface ChatInfoMapper extends BaseMapper<ChatInfo> {
    @Insert("insert into chat_info(sourceid, targetid, createTime, msg, `got`, `isSys`) values(#{sourceid}, #{targetid}, #{createTime}, #{msg}, #{got}, #{isSys})")
    public int insertOne(ChatInfo chatInfo);

    @Update("update chat_info set got = 1 where sourceid = #{sourceid} and targetid = #{targetid}") // and createTime = #{createTime}
    public int updateOne(ChatInfo chatInfo);

    @Select("select *, (select username form user_info where userid = #{sourceid}) as sourcename, " +
            "(select username form user_info where userid = #{targetid}) as targetname " +
            "from chat_info where sourceid = #{sourceid} and targetid = #{targetid} and createTime = #{time}")
    public ChatInfo getOne(String sourceid, String targetid, int time);

    @Select("select * from chat_info where ((sourceid = #{sourceid} and targetid = #{targetid} ) or (sourceid = #{targetid} and targetid = #{sourceid} )) and createTime > #{time} order by createTime desc limit 100 offset #{skip}")
    public List<ChatInfo> getDialogAll(String sourceid, String targetid, int time, int skip);

//    @Select("SELECT `a`.* FROM " +
//            "( " +
//            "SELECT `c`.*, `u`.username  FROM chat_info AS `c` LEFT JOIN user_info AS `u` ON `u`.userid = `c`.sourceid WHERE `c`.sourceid = 'public' ORDER BY `c`.createTime DESC LIMIT 1000" +
//            ") AS `a`" +
//            "GROUP BY `a`.sourceid limit #{skip}")
////    @Select("select * from chat_info where sourceid = #{userid} or targetid = #{userid}) and createTime > #{time}  order by createTime desc limit 100 offset #{skip}")
//    public List<ChatInfo> getUserAll(String userid, int time, int skip);

    @Select("SELECT `a`.* FROM" +
            "( " +
            "SELECT `c`.*, `u`.username  FROM chat_info AS `c`, " +
            " user_info AS `u` where ((`u`.userid = `c`.sourceid AND `c`.targetid = #{userid} ) OR (`u`.userid = `c`.targetid AND `c`.sourceid = #{userid} )) " +
            "and createTime > #{time} ORDER BY `c`.createTime DESC LIMIT 1000 " +
            ") AS `a`" +
            "GROUP BY `a`.targetid, `a`.sourceid LIMIT 100 offset #{skip}")
    public List<ChatInfo> getRecentDialog(String userid, int time, int skip);

    @Select("SELECT `a`.* FROM " +
            "( " +
            "SELECT `c`.*, `u`.username  FROM chat_info AS `c` LEFT JOIN user_info AS `u` ON `u`.userid = `c`.sourceid WHERE `c`.targetid = #{userid} ORDER BY `c`.createTime DESC LIMIT 1000" +
            ") AS `a`" +
            "GROUP BY `a`.sourceid limit 100 offset #{skip}")
    public List<ChatInfo> getRecentRevDialog(String userid, int time, int skip);

    @Select("SELECT `a`.* FROM " +
            "( " +
            "SELECT `c`.*, `u`.username  FROM chat_info AS `c` LEFT JOIN user_info AS `u` ON `u`.userid = `c`.targetid WHERE `c`.sourceid = #{userid} ORDER BY `c`.createTime DESC LIMIT 1000" +
            ") AS `a`" +
            "GROUP BY `a`.targetid limit 100 offset #{skip}")
    public List<ChatInfo> getRecentSendDialog(String userid, int time, int skip);

    @Delete("delete from chat_info where createTime < #{time}")
    public int deleteByTime(int time);

    @Delete("delete from chat_info where sourceid = #{userid} or targetid = #{targetid}")
    public int deleteByUser(String userid);
}
