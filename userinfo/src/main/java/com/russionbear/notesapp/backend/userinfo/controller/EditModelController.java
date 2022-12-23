package com.russionbear.notesapp.backend.userinfo.controller;

import com.russionbear.notesapp.backend.userinfo.entity.EditModel;
import com.russionbear.notesapp.backend.userinfo.mapper.EditModelMapper;
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
@RequestMapping("/userinfo/editModel")
public class EditModelController {
    @Resource
    EditModelMapper editModelMapper;

    @PostMapping("/insert")
    public String insertOne(EditModel editModel){
        return editModelMapper.insertOne(editModel) + "";
    }

    @PostMapping
    public String updateOne(EditModel editModel){
        return editModelMapper.updateOne(editModel) + "";
    }

    @PostMapping("/delete/{userid}/{name}")
    public String deleteOne(@PathVariable String name, @PathVariable String userid){
        String rlt = editModelMapper.deleteOne(userid, name) + "";
        System.out.println(rlt+";"+userid+";"+name);
        return rlt;
    }

    @PostMapping("/delete/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return editModelMapper.deleteByUser(userid)  + "";
    }

    @PostMapping("/search/{kw}/{skip}")
    public List<EditModel> search(@PathVariable String kw, @PathVariable int skip){
        return editModelMapper.search("%"+kw+"%", skip);
    }

    @PostMapping("/user/{userid}/{skip}")
    public List<EditModel> getAll(@PathVariable String userid, @PathVariable int skip){
        return editModelMapper.getAll(userid, skip);
    }
}
