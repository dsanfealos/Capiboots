
package com.example.CapiBoots.controladores.streaming;


import com.example.CapiBoots.modelos.FileInfo;
import com.example.CapiBoots.servicios.file.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
