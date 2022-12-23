package com.russionbear.notesapp.backend.userinfo.controller;

import com.russionbear.notesapp.backend.userinfo.entity.ChatInfo;
import com.russionbear.notesapp.backend.userinfo.mapper.ChatInfoMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
@RequestMapping("/userinfo/chatInfo")
public class ChatInfoController {
    @Resource
    ChatInfoMapper chatInfoMapper;

    @PostMapping("/recent/{userid}/{time}/{skip}")
    public List<ChatInfo> getUserAll(@PathVariable String userid, @PathVariable int time, @PathVariable int skip){
        return chatInfoMapper.getRecentDialog(userid , time, skip);
    }

    @PostMapping("/rev/{userid}/{time}/{skip}")
    public List<ChatInfo> getUserRevAll(@PathVariable String userid, @PathVariable int time, @PathVariable int skip){
        return chatInfoMapper.getRecentRevDialog(userid , time, skip);
    }

    @PostMapping("/send/{userid}/{time}/{skip}")
    public List<ChatInfo> getUserSendAll(@PathVariable String userid, @PathVariable int time, @PathVariable int skip){
        return chatInfoMapper.getRecentSendDialog(userid , time, skip);
    }

    @PostMapping("/dialog/{sourceid}/{targetid}/{time}/{skip}")
    public List<ChatInfo> getDialogAll(@PathVariable String sourceid, @PathVariable String targetid, @PathVariable int time, @PathVariable int skip){
        return chatInfoMapper.getDialogAll(sourceid, targetid, time, skip);
    }

    @PostMapping("/{sourceid}/{targetid}/{time}")
    public ChatInfo getOne(@PathVariable String sourceid, @PathVariable String targetid, @PathVariable int time){
        return chatInfoMapper.getOne(sourceid, targetid, time);
    }

    @PostMapping("/insert")
    public String insertOne(ChatInfo chatInfo){
        try{
            chatInfo.setCreateTime((int) (System.currentTimeMillis()/1000));
            chatInfo.setGot((byte) 0);
            chatInfo.setIsSys((byte) 0);
            System.out.println(chatInfo);
            return chatInfoMapper.insertOne(chatInfo) + "";
        }
        catch (Exception e){}
        return "0";
    }

    @PostMapping
    public String updateOne(ChatInfo chatInfo){
        try{
            return chatInfoMapper.updateOne(chatInfo) + "";
        }
        catch (Exception e){}
        return "0";
    }

    @DeleteMapping("/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return chatInfoMapper.deleteByUser(userid) + "";
    }
}
