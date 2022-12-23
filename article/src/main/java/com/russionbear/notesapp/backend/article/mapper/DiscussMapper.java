package com.russionbear.notesapp.backend.article.mapper;

import com.russionbear.notesapp.backend.article.entity.Discuss;
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
public interface DiscussMapper extends BaseMapper<Discuss> {
    @Insert("insert into discuss(userid, noteid, createTime, `value`) value(#{userid}, #{noteid}, #{createTime}, #{value})")
    public int insertOne(Discuss discuss);

    @Delete("delete from discuss where userid = #{userid} and noteid = #{noteid} and createTime = #{createTime}")
    public int deleteOne(String noteid, String userid, int createTime);

    @Delete("delete from discuss where noteid = #{noteid}")
    public int deleteAll(String noteid);

    @Select("select `d`.*, `u`.username as username from discuss as `d` left join user_info as `u` on `d`.userid = `u`.userid where  `d`.noteid = #{noteid} order by `d`.createTime")
    public List<Discuss> getAll(String noteid);
}
