package com.russionbear.notesapp.backend.resource.controller;


import com.russionbear.notesapp.backend.resource.entity.ResourceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/note")
public class TemplateController {
    @Value("${note.dir}")
    String notePath;

    @GetMapping(value = "/{name}", produces = {MediaType.TEXT_HTML_VALUE})
    public String getIndexHtml(@PathVariable String name) throws IOException {
//        String tmpPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
//        if(tmpPath.endsWith("!/")){
//            int tmpIndex = tmpPath.indexOf("!/");
//            tmpPath = tmpPath.substring(0, tmpIndex);
//            tmpIndex = tmpPath.lastIndexOf("/");
//            tmpPath = tmpPath.substring(0, tmpIndex);
//        }else{
//            System.out.println(tmpPath);
//            int tmpIndex = tmpPath.lastIndexOf("/");
//            tmpPath = tmpPath.substring(0, tmpIndex-1);
//            tmpIndex = tmpPath.lastIndexOf("/");
//            tmpPath = tmpPath.substring(0, tmpIndex);
//        }
//        System.out.println(tmpPath);
        File file = new File(notePath+"/"+name);
        if (!file.exists()) {
            return null;
        }else{
            Path path = Paths.get(notePath+"/"+name);
//            byte[] bytes = Files.readAllBytes(path);
//            return bytes;
            return Files.readString(path);
        }
    }

    @GetMapping(value = "/{root}/{name}", produces = {MediaType.TEXT_HTML_VALUE})
    public byte[] getAssets(@PathVariable String name, @PathVariable String root) throws IOException {
        File file = new File(notePath+"/"+root+"/"+name);
        if (!file.exists()) {
            return null;
        }else{
            Path path = Paths.get(notePath+"/"+root+"/"+name);
            byte[] bytes = Files.readAllBytes(path);
            return bytes;
        }
    }
}
