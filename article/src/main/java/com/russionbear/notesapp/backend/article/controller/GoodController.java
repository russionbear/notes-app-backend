package com.russionbear.notesapp.backend.article.controller;

import com.russionbear.notesapp.backend.article.entity.Good;
import com.russionbear.notesapp.backend.article.mapper.GoodMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author russionbear
 * @since 2022-12-16
 */

@RestController
@RequestMapping("/article/good")
public class GoodController {
    @Resource
    GoodMapper goodMapper;

    @GetMapping("/{noteid}")
    public String GetAllNu(@PathVariable String noteid){
        return goodMapper.getAllNu(noteid) +"";
    }

//    @PutMapping
    @PostMapping("/insert")
    public String insertOne(Good good){
        return goodMapper.insertOne(good) + "";
    }

    @GetMapping("/{noteid}/{userid}")
    public String getOne(@PathVariable String noteid, @PathVariable String userid){
        return goodMapper.getOne(noteid, userid) != null?"1":"0";
    }

    @PostMapping("/delete/{noteid}/{userid}")
    public String deleteOne(@PathVariable String noteid, @PathVariable String userid){
        return goodMapper.deleteOne(noteid, userid)+"";
    }

    @DeleteMapping("/{noteid}")
    public String deleteAll(String noteid){
        return goodMapper.deleteAll(noteid) + "";
    }

}
