package com.russionbear.notesapp.backend.userinfo.mapper;

import com.russionbear.notesapp.backend.userinfo.entity.EditModel;
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
public interface EditModelMapper extends BaseMapper<EditModel> {
    // 防止字段名跟关键字冲突, returnType must be int , or be throw error
    @Insert("insert into edit_model(`userid`, `name`, `dsc`, `value`) value(#{userid}, #{name}, #{dsc}, #{value})")
    public int insertOne(EditModel editModel);

    @Update("update edit_model set `value` = #{value} where userid = #{userid} and `name` = #{name}")
    public int updateOne(EditModel editModel);

    @Delete("delete `e` from edit_model as `e` where `e`.`userid` = #{userid} and `e`.`name` = #{name}")
    public int deleteOne(String userid, String name);

    @Delete("delete from edit_model where userid = #{userid}")
    public int deleteByUser(String userid);

    @Select("select * from edit_model where `name` like #{kw} or `dsc` like #{kw} limit 20 offset #{skip}")
    public List<EditModel> search(String kw, int skip);

    @Select("select * from edit_model where userid = #{userid} limit 20 offset #{skip}")
    public List<EditModel> getAll(String userid, int skip);

}
