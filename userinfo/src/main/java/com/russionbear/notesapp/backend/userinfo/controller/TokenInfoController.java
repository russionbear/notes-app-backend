package com.russionbear.notesapp.backend.userinfo.controller;

import com.russionbear.notesapp.backend.userinfo.entity.TokenInfo;
import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
import com.russionbear.notesapp.backend.userinfo.mapper.TokenInfoMapper;
import com.russionbear.notesapp.backend.userinfo.mapper.UserInfoMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author russionbear
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/userinfo/tokenInfo")
public class TokenInfoController {
    @Resource
    TokenInfoMapper tokenInfoMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    @DeleteMapping("/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return tokenInfoMapper.deleteByUser(userid)+ "";
    }

    @PostMapping
    public TokenInfo getToken(UserInfo userInfo){
        UserInfo newUserInfo = userInfoMapper.getOneByUserId(userInfo.getUserid());
        if(newUserInfo==null||newUserInfo.getPassword()!=userInfo.getPassword()){
            return null;
        }
        tokenInfoMapper.insertOne(userInfo.getUserid());
        return tokenInfoMapper.getOne(userInfo.getUserid());
    }

    @PostMapping("/token")
    public UserInfo getUserInfo(TokenInfo tokenInfo){
        return tokenInfoMapper.getUserInfo(tokenInfo);
    }
}
