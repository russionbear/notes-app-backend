package com.russionbear.notesapp.backend.article.mapper;

import com.russionbear.notesapp.backend.article.entity.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */
@Mapper
public interface GoodMapper extends BaseMapper<Good> {

    @Select("select * from good where noteid = #{noteid} and userid = #{userid}")
    public Good getOne(String noteid, String userid);

    @Insert("insert into good(userid, noteid) values(#{userid}, #{noteid})")
    public int insertOne(Good good);

    @Delete("delete from good where userid = #{userid} and noteid = #{noteid}")
    public int deleteOne(String userid, String noteid);

    @Delete("delete from good where noteid = #{noteid}")
    public int deleteAll(String noteid);

    @Select("select count(*) from good where noteid = #{noteid}")
    public int getAllNu(String noteid);
}
