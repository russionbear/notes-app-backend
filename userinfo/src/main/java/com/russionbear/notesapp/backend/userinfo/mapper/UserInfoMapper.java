package com.russionbear.notesapp.backend.userinfo.mapper;

import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
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
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from user_info limit 100 offset #{skip}")
    public List<UserInfo> getAll(int skip);


    @Select("select count(*) from user_info")
    public int getAllNu();

    @Select("select * from user_info where email = #{email}")
    public UserInfo getOneByEmail(String email);

    @Select("select * from user_info where userid = #{userid}")
    public UserInfo getOneByUserId(String userid);

    @Select("select * from user_info where username = #{username}")
    public UserInfo getOneByUserName(String username);

    @Select("select * from user_info where username = #{username} and password = #{password}")
    public UserInfo checkByUserName(String username, String password);

    @Select("select * from user_info where email = #{email} and password = #{password}")
    public UserInfo checkByUserEmail(String email, String password);

    @Insert("insert into user_info(email, username, password) values(#{email}, #{username}, #{password})")
    //@Insert("insert into user_info values(#{userid}, #{email}, #{username}, #{password})")
    public int insertOne(UserInfo userInfo);

    @Update("update user_info set `drop` = 1 where userid = #{userid}")
    public int deleteOneLogic(String userid);

    @Update("delete from user_info where userid = #{userid}")
    public int deleteOne(String userid);
}
