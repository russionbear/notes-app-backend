package com.russionbear.notesapp.backend.userinfo.mapper;

import com.russionbear.notesapp.backend.userinfo.entity.Collection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
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
public interface CollectionMapper extends BaseMapper<Collection> {

    @Select("select `c`.*, `n`.notename, `n`.bookname, `u`.username from " +
            "collection as `c` left join note_info as `n` on `c`.noteid = `n`.noteid left join user_info as `u` on `u`.userid = `n`.userid " +
            " where `c`.userid = #{userid} and `n`.noteid = #{noteid}")
    public Collection getOne(String userid, String noteid);

    @Select("select `c`.*, `n`.notename, `n`.bookname, `u`.username from " +
            "collection as `c` left join note_info as `n` on `c`.noteid = `n`.noteid left join user_info as `u` on `u`.userid = `n`.userid " +
            " where `c`.userid = #{userid} limit 100 offset #{skip}")
    public List<Collection> getAllCollection(String userid, int skip);

    @Select("select count(*) from collection where userid = #{userid} ")
    public int getAllCollectionNu(String userid);

    @Insert("insert into collection(userid, noteid) values(#{userid}, #{noteid})")
    public int insertOne(Collection collection);

    @Delete("delete from collection where userid = #{userid} and noteid = #{noteid}")
    public int deleteOne(String userid, String noteid);

    @Delete("delete from collection where userid = #{userid}")
    public int deleteByUser(String userid);
}
