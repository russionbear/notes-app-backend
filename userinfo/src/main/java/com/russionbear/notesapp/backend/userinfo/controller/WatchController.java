package com.russionbear.notesapp.backend.userinfo.controller;

import com.russionbear.notesapp.backend.userinfo.entity.Collection;
import com.russionbear.notesapp.backend.userinfo.entity.UserInfo;
import com.russionbear.notesapp.backend.userinfo.entity.Watch;
import com.russionbear.notesapp.backend.userinfo.mapper.CollectionMapper;
import com.russionbear.notesapp.backend.userinfo.mapper.WatchMapper;
import org.apache.catalina.User;
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
@RequestMapping("/userinfo/watch")
public class WatchController {
    @Resource
    WatchMapper watchMapper;
    @PostMapping("/{userid}/{skip}")
    public List<Watch> getAllWatched(@PathVariable int skip, @PathVariable String userid){
        return watchMapper.getAllWatched(userid, skip);
    }

    @GetMapping("/{userid}")
    public String getAllWatchedNu(@PathVariable String userid){
        return watchMapper.getAllWatchedNu(userid) + "";
    }


    @PostMapping("/by/{userid}/{skip}")
    public List<Watch> getAllBeWatched(@PathVariable int skip, @PathVariable String userid){
        return watchMapper.getAllBeWatched(userid, skip);
    }

    @GetMapping("/by/{userid}")
    public String getAllBeWatchedNu(@PathVariable String userid){
        return watchMapper.getAllBeWatchedNu(userid) + "";
    }


    @GetMapping("/{sourceid}/{targetid}")
    public String getOne(@PathVariable String sourceid, @PathVariable String targetid){
        return watchMapper.getOne(sourceid, targetid) == null ? "0": "1";
    }

    @PostMapping("/insert")
    public String insertOne(Watch watch){
        return watchMapper.insertOne(watch) + "";
    }

    @PostMapping("/delete/{userid}/{targetid}")
    public String deleteOne(@PathVariable String targetid, @PathVariable String userid){
        return watchMapper.deleteOne(userid, targetid) + "";
    }

    @DeleteMapping("/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return watchMapper.deleteByUser(userid) + "";
    }
}
