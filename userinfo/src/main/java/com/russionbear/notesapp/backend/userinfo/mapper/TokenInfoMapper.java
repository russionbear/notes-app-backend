package com.russionbear.notesapp.backend.userinfo.mapper;

import com.russionbear.notesapp.backend.userinfo.entity.TokenInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
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
 * @since 2022-12-17
 */
@Mapper
public interface TokenInfoMapper extends BaseMapper<TokenInfo> {
    @Delete("delete from token_info where userid = #{userid}")
    public int deleteByUser(String userid);

    @Insert("insert into token_info(userid) values(#{userid})")
    public int insertOne(String userid);

    @Select("select * from token_info where userid = #{userid} limit 1")
    public TokenInfo getOne(String userid);

    @Select("select * from user_info where userid = (select userid from token_info where token = #{token})")
    public UserInfo getUserInfo(TokenInfo tokenInfo);


}
