package com.russionbear.notesapp.backend.article.mapper;

import com.russionbear.notesapp.backend.article.entity.StorageInfo;
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
public interface StorageInfoMapper extends BaseMapper<StorageInfo> {
    @Select("select `s`.*, `u`.username as username from storage_info as `s` left join user_info as `u` on `u`.userid = `s`.userid and `u`.userid = #{userid} ")
    public List<StorageInfo> getAllById(String userid);

    @Select("select `s`.*, `u`.username as username from storage_info as `s` left join user_info as `u` on `u`.userid = `s`.userid and `u`.username = #{username} ")
    public List<StorageInfo> getAllByName(String username);

    @Insert("insert into storage_info(bookname, userid) values(#{bookname}, #{userid})")
    public int insertOne(StorageInfo storageInfo);

    @Delete("delete from storage_info where bookname = #{bookname} and userid = #{userid}")
    public int deleteOne(String userid, String bookname);

    @Delete("delete from resource_info as `r` left join note_info as `n` on `r`.`noteid` = `n`.`noteid` where `n`.userid = #{userid} and `n`.bookname = #{bookname}")
    public int deleteBookResource(String userid, String bookname);

    @Delete(("delete from storage_info where userid = #{userid}"))
    public int deleteAll(String userid);

    @Update("update storage_info set bookname = #{newname} where bookname = #{oldname} and userid = #{userid}")
    public int rename(String oldname, String newname, String userid);

    @Update("update note_info set bookname = #{newname} where bookname = #{oldname} and userid = #{userid}")
    public int renameNote(String oldname, String newname, String userid);
}
