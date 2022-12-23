package com.russionbear.notesapp.backend.userinfo.controller;

import com.russionbear.notesapp.backend.userinfo.entity.Collection;
import com.russionbear.notesapp.backend.userinfo.mapper.CollectionMapper;
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
@RequestMapping("/userinfo/collection")
public class CollectionController {
    @Resource
    CollectionMapper collectionMapper;

    @GetMapping("/{userid}/{noteid}")
    public String getOne(@PathVariable String noteid, @PathVariable String userid){
        return collectionMapper.getOne(userid, noteid) !=null ?"1" : "0";
    }

    @PostMapping("/{userid}/{skip}")
    public List<Collection> getAllCollection(@PathVariable int skip, @PathVariable String userid){
        return collectionMapper.getAllCollection(userid, skip);
    }

    @GetMapping("/{userid}")
    public String GetAllCollectionNu(@PathVariable String userid){
        return collectionMapper.getAllCollectionNu(userid) + "";
    }

//    @PutMapping()
    @PostMapping("/insert")
    public String insertOne(Collection collection){
        return collectionMapper.insertOne(collection) + "";
    }

//    @DeleteMapping("/{userid}/{noteid}")
    @PostMapping("/delete/{userid}/{noteid}")
    public String deleteOne(@PathVariable String noteid, @PathVariable String userid){
        return collectionMapper.deleteOne(userid, noteid) + "";
    }

    @DeleteMapping("/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return collectionMapper.deleteByUser(userid) + "";
    }
}
