package com.russionbear.notesapp.backend.userinfo.mapper;

import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
import com.russionbear.notesapp.backend.userinfo.entity.Watch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface WatchMapper extends BaseMapper<Watch> {
    @Select("select *, (select username from user_info where userid = #{targetid}) as targetname from `watch` where userid = #{sourceid} and targetid = #{targetid}")
    public Watch getOne(String sourceid, String targetid);


    @Select("select `w`.*, `u`.username as targetname from watch as `w` left join user_info as `u` on `u`.userid = `w`.targetid and `w`.userid = #{userid} limit 100 offset #{skip}")
//    @Select("select * from user_info where userid in (" +
//            "select targetid from watch where userid = #{userid}" +
//            ") limit 100 offset #{skip}")
    public List<Watch> getAllWatched(String userid, int skip);

    @Select("select count(*) from watch where userid = #{userid}")
    public int getAllWatchedNu(String userid);


    @Select("select `w`.*, `u`.username as targetname from watch as `w` left join user_info as `u` on `u`.userid = `w`.userid and `w`.targetid = #{userid} limit 100 offset #{skip}")
//    @Select("select * from user_info where userid in (" +
//            "select userid from watch where targetid = #{userid}" +
//            ") limit 100 offset #{skip}")// 获取粉丝
    public List<Watch> getAllBeWatched(String userid, int skip);

    @Select("select count(*) from watch where targetid = #{userid}")// 获取粉丝 数量
    public int getAllBeWatchedNu(String userid);

    @Insert("insert into watch(userid, targetid) values(#{userid}, #{targetid})")
    public int insertOne(Watch watch);

    @Delete("delete from watch where userid = #{userid} and targetid = #{targetid}")
    public int deleteOne(String userid, String targetid);

    @Delete("delete from watch where userid = #{userid}")
    public int deleteByUser(String userid);
}
