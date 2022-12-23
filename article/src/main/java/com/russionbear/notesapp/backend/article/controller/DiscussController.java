package com.russionbear.notesapp.backend.article.controller;

import com.russionbear.notesapp.backend.article.entity.Discuss;
import com.russionbear.notesapp.backend.article.mapper.DiscussMapper;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/article/discuss")
public class DiscussController {
    @Resource
    DiscussMapper discussMapper;

//    @PutMapping
    @PostMapping("/insert")
    public String insertOne(Discuss discuss){
        discuss.setCreateTime((int) (System.currentTimeMillis()/1000));
        return discussMapper.insertOne(discuss) + "";
    }

    @PostMapping("/delete/{userid}/{noteid}/{createTime}")
    public String deleteOne(@PathVariable String noteid, @PathVariable int createTime, @PathVariable String userid){
        return discussMapper.deleteOne(noteid, userid, createTime) + "";
    }

    @PostMapping("/delete/{noteid}")
    public String deleteAll(@PathVariable String noteid){
        return discussMapper.deleteAll(noteid) + "";
    }

    @PostMapping("/{noteid}")
    public List<Discuss> getAll(@PathVariable String noteid){
        return discussMapper.getAll(noteid);
    }
}
