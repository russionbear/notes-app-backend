package com.russionbear.notesapp.backend.article.controller;

import com.russionbear.notesapp.backend.article.entity.NoteInfo;
import com.russionbear.notesapp.backend.article.mapper.NoteInfoMapper;
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
@RequestMapping("/article/noteInfo")
public class NoteInfoController {
    @Resource
    NoteInfoMapper noteInfoMapper;

//    @Resource
//    RestTemplate restTemplate;

    @PostMapping("/one/{noteid}")
    public NoteInfo getOne(@PathVariable String noteid){
        return noteInfoMapper.getOne(noteid);
    }

    @PostMapping("/{username}/{bookname}/{notename}")
    public NoteInfo getOneByFull(@PathVariable String username, @PathVariable String bookname, @PathVariable String notename){
        return noteInfoMapper.getOneByFull(username, bookname, notename);
    }


    @PostMapping("/search/{kw}")
    public List<NoteInfo> search(@PathVariable String kw){
        List<NoteInfo> rlt = noteInfoMapper.search("%"+kw+"%");
        for (NoteInfo item :
                rlt) {
            System.out.println(item.toString());
        }
        return rlt;
    }

    @PostMapping("/{username}/{bookname}")
    public List<NoteInfo> getAll(@PathVariable String bookname, @PathVariable String username){
        return noteInfoMapper.getAll(username, bookname);
    }

//    @PutMapping
//    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/insert")
    public NoteInfo insertOne(NoteInfo noteInfo){
        noteInfo.setUpdateTime((int) (System.currentTimeMillis()/1000));
        noteInfoMapper.insertOne(noteInfo);
        NoteInfo rlt = noteInfoMapper.getOneByFull(noteInfo.getUsername(), noteInfo.getBookname(), noteInfo.getNotename());
        noteInfoMapper.uploadEmptyResource(rlt.getNoteid(), "__content__", "", (int) (System.currentTimeMillis()/1000));
//        resourceClient.uploadData("__content__", rlt.getNoteid());
//        restTemplate.getForObject("http://resource/resource/resourceInfo/insert/"+rlt.getNoteid()+"/__content__", String.class);
        return rlt;
    }

    @PostMapping("/rename/{notename}/{noteid}")
    public String updateName(@PathVariable String notename, @PathVariable String noteid){
        return noteInfoMapper.updateName(notename, noteid)  + "";
    }

    @PostMapping("/delete/{noteid}")
    public String deleteOne(@PathVariable String noteid){
        noteInfoMapper.deleteNoteResource(noteid);
        return noteInfoMapper.deleteOne(noteid) + "";
    }


    @DeleteMapping("/delete/user/{userid}/{bookname}")
    public String deleteByBook(@PathVariable String userid, @PathVariable String bookname){
        return noteInfoMapper.deleteByBook(userid, bookname) + "";
    }


    @DeleteMapping("/user/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return noteInfoMapper.deleteByUser(userid) + "";
    }

}
