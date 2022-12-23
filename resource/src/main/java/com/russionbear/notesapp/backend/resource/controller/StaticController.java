package com.russionbear.notesapp.backend.resource.controller;

import com.russionbear.notesapp.backend.resource.config.NonStaticResourceHttpRequestHandler;
import com.russionbear.notesapp.backend.resource.entity.ResourceInfo;
import com.russionbear.notesapp.backend.resource.mapper.ResourceInfoMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/static")
public class StaticController {

    @Resource
    ResourceInfoMapper resourceInfoMapper;

    @GetMapping(value = "/{noteid}", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_MARKDOWN_VALUE})
    public byte[] getResourceById(@PathVariable String noteid){
        return resourceInfoMapper.getResource(noteid, "__content__");
    }

//    @GetMapping(value = "/{noteid}/{name}", produces = MediaType.ALL_VALUE)
//    public byte[] getResourceById(@PathVariable String name, @PathVariable String noteid){
//         return resourceInfoMapper.getResource(noteid, name);
//    }

    @GetMapping(value = "/{username}/{bookname}/{notename}", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_MARKDOWN_VALUE})
    public byte[] getResourceByName(@PathVariable String bookname, @PathVariable String notename, @PathVariable String username){
        return resourceInfoMapper.getResourceByName(username, bookname, notename, "__content__");
    }

    @GetMapping(value = "/{username}/{bookname}/{notename}/{name}", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_MARKDOWN_VALUE})
    public byte[] getResourceByName(@PathVariable String bookname, @PathVariable String name, @PathVariable String notename, @PathVariable String username){
        ResourceInfo rlt = resourceInfoMapper.getResourceByName2(username, bookname, notename, name);
        if(rlt==null)
            return null;
        return rlt.getValue();
    }

    @GetMapping(value = "/image/{username}/{bookname}/{notename}/{name}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public byte[] getImageByName(@PathVariable String bookname, @PathVariable String name, @PathVariable String notename, @PathVariable String username){
        ResourceInfo rlt = resourceInfoMapper.getResourceByName2(username, bookname, notename, name);
        return rlt.getValue();
    }

    @Resource
    NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @GetMapping(value = "/video/{username}/{bookname}/{notename}/{name}")
    public void getVideoByName(@PathVariable String bookname, @PathVariable String name,
                                 @PathVariable String notename, @PathVariable String username,
                                 HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceInfo rlt = resourceInfoMapper.getResourceByName2(username, bookname, notename, name);
        response.setContentType("video/mp4");
        response.setContentLength(rlt.getValue().length);
        OutputStream os = response.getOutputStream();
        os.write(rlt.getValue());
        os.flush();
        os.close();
    }

    @GetMapping(value = "/audio/{username}/{bookname}/{notename}/{name}", produces = {MediaType.ALL_VALUE})
    public void getAudioByName(@PathVariable String bookname,
                               @PathVariable String name, @PathVariable String notename,
                               @PathVariable String username, HttpServletResponse response) throws IOException {
        ResourceInfo rlt = resourceInfoMapper.getResourceByName2(username, bookname, notename, name);
        response.setContentType("audio/mpeg");
        response.setContentLength(rlt.getValue().length);
        OutputStream os = response.getOutputStream();
        os.write(rlt.getValue());
        os.flush();
        os.close();
    }

}
