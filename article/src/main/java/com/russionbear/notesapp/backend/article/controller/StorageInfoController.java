package com.russionbear.notesapp.backend.article.controller;

import com.russionbear.notesapp.backend.article.entity.StorageInfo;
import com.russionbear.notesapp.backend.article.mapper.NoteInfoMapper;
import com.russionbear.notesapp.backend.article.mapper.StorageInfoMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/article/storageInfo")
public class StorageInfoController {
    @Resource
    StorageInfoMapper storageInfoMapper;

    @Resource
    NoteInfoMapper noteInfoMapper;

    @PostMapping("/userid/{userid}")
    public List<StorageInfo> getAllById(@PathVariable String userid){
        return storageInfoMapper.getAllById(userid);
    }

    @PostMapping("/{username}")
    public List<StorageInfo> getAllByName(@PathVariable String username){
        List<StorageInfo> rlt = storageInfoMapper.getAllByName(username);
        System.out.println(rlt);
        return  rlt;
    }

//    @PutMapping
    @PostMapping("/insert")
    public String insertOne(StorageInfo storageInfo){
        System.out.println(storageInfo);
        return storageInfoMapper.insertOne(storageInfo) + "";
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/{userid}/{oldName}/{newName}")
    public String rename(@PathVariable String newName, @PathVariable String oldName, @PathVariable String userid){
        storageInfoMapper.renameNote(oldName, newName, userid);
        return storageInfoMapper.rename(oldName, newName, userid) + "";
    }


    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/delete/{userid}/{bookname}")
    public String deleteOne(@PathVariable String bookname, @PathVariable String userid){
        storageInfoMapper.deleteBookResource(userid, bookname);
        noteInfoMapper.deleteByBook(userid, bookname);
        return storageInfoMapper.deleteOne(userid, bookname) + "";
    }

    @DeleteMapping("/{userid}")
    public String deleteAll(@PathVariable String userid){
        return storageInfoMapper.deleteAll(userid) + "";
    }

}
