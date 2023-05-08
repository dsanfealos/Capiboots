package com.example.CapiBoots.controladores.streaming;


import ch.qos.logback.core.model.Model;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VideoListCtrl {
    @Autowired
    FileSystemStorageService fileSystemStorageService;
    @GetMapping("/videos")
    public String listAllVideos(Model model){
        List<FileInfo> videoFiles = fileSystemStorageService.loadAllByFileType("video");
        model.addAttribute("videos", videoFiles);
        return "videos";
    }
}