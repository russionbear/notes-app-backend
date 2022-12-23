package com.russionbear.notesapp.backend.resource.controller;

import com.russionbear.notesapp.backend.resource.entity.ResourceInfo;
import com.russionbear.notesapp.backend.resource.mapper.ResourceInfoMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
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
@RequestMapping("/resource/resourceInfo")
public class ResourceInfoController {

    @Resource
    ResourceInfoMapper resourceInfoMapper;

//    @PutMapping
//    public String updateData(ResourceInfo resourceInfo){
//        System.out.println(resourceInfo.toString());
//        return resourceInfoMapper.uploadData(resourceInfo) + "";
//    }

    @PostMapping("/update/{noteid}/{name}")
    public String updateOne(@PathVariable String name, @PathVariable String noteid,
                            HttpServletRequest request)throws ServletException, IOException{
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        byte[] content = mRequest.getFile("file").getBytes();
        System.out.println(Arrays.toString(content));
        return resourceInfoMapper.updateOne(content, noteid, name) + "";
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/insert/{noteid}/{name}")
    public ResourceInfo uploadData(@PathVariable String noteid, @PathVariable String name ,
                             HttpServletRequest request) throws ServletException, IOException {
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setName(name);
        String[] tmpName = name.split("[.]");
        if(tmpName.length==0){
            return null;
        }
        if(tmpName.length==1){
            resourceInfo.setType(".txt");
        }else{
            resourceInfo.setType(tmpName[tmpName.length-1]);
        }
        resourceInfo.setCreateTime((int) (System.currentTimeMillis()/1000));
        resourceInfo.setNoteid(noteid);

        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        String tmpType = mRequest.getFile("file").getContentType();
        System.out.println(tmpType);

        if(mRequest.getFile("file")==null){
            resourceInfo.setValue(null);
        }else{
            resourceInfo.setValue(mRequest.getFile("file").getBytes());
        }

        resourceInfoMapper.uploadData(resourceInfo);
        return resourceInfoMapper.getOneInfo(resourceInfo.getNoteid(), resourceInfo.getName());
    }

    @PostMapping("/{noteid}/{name}")
    public ResourceInfo getOneInfo(@PathVariable String noteid, @PathVariable String name){
        return resourceInfoMapper.getOneInfo(noteid, name);
    }

    @PostMapping("/{noteid}")
    public List<ResourceInfo> getAllInfo(@PathVariable String noteid){
        return resourceInfoMapper.getAllInfo(noteid);
    }

    @PostMapping("/rename/{noteid}/{oldname}/{newname}")
    public String rename(@PathVariable String noteid, @PathVariable String oldname, @PathVariable String newname){
        return resourceInfoMapper.rename(noteid, oldname, newname) + "";
    }

    @PostMapping("/delete/{noteid}/{name}")
    public String deleteOne(@PathVariable String name, @PathVariable String noteid){
        return resourceInfoMapper.deleteOne(noteid, name) + "";
    }

    @PostMapping("/delete/{noteid}")
    public String deleteArticle(@PathVariable String noteid){
        return resourceInfoMapper.deleteByArticle(noteid) + "";
    }

    @DeleteMapping("/user/{userid}")
    public String deleteByUser(@PathVariable String userid){
        return resourceInfoMapper.deleteByUser(userid) + "";
    }

}
