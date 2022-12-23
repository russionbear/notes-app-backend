package com.russionbear.notesapp.backend.userinfo.controller;

import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
import com.russionbear.notesapp.backend.userinfo.mapper.UserInfoMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */
@RestController
@RequestMapping("/userinfo/userinfo")
public class UserInfoController {
    @Resource
    UserInfoMapper userInfoMapper;

    @GetMapping
    public String getAllNu(){
        return userInfoMapper.getAllNu() +"";
    }

    @PostMapping("/view")
    public List<UserInfo> getAll(@RequestParam int skip){
        return userInfoMapper.getAll(skip);
    }

//    @PutMapping()
    @PostMapping("/insert")
    public String insertOne(UserInfo userInfo){
        try{
            return userInfoMapper.insertOne(userInfo)+"";
        }
        catch (Exception e){
            return "0";
        }
    }

//    @PostMapping("/email/{email}")
//    public UserInfo getOneByEmail(@PathVariable String email){
//        return userInfoMapper.getOneByEmail(email);
//    }

    @PostMapping("/userid/{userid}")
    public UserInfo getOneByUserId(@PathVariable String userid){
        return userInfoMapper.getOneByUserId(userid);
    }

//    @DeleteMapping("/userid/{userid}")
    @PostMapping("/delete/userid/{userid}")
    public String delete(@PathVariable String userid){
        return userInfoMapper.deleteOneLogic(userid)+"";
    }

    @PostMapping("/username/{username}")
    public UserInfo getOneByUserName(@PathVariable String username){
        return userInfoMapper.getOneByUserName(username);
    }

    @PostMapping("/check")
    public UserInfo checkUserInfo(HttpServletRequest request){
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        if(password==null)
            return null ;

        if((username==null||username.length()==0)&&(email==null||email.length()==0)){
            return null;
        }
        else if(email==null||email.length()==0){
            return userInfoMapper.checkByUserName(username, password);
        }
        else{
            return userInfoMapper.checkByUserEmail(email, password);
        }
    }


}
