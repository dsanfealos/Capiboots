package com.example.CapiBoots;

import com.example.CapiBoots.servicios.file.FileSystemStorageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapiBootsApplication {
@Autowired
FileSystemStorageService fileSystemStorageService;
	public static void main(String[] args) {
		SpringApplication.run(CapiBootsApplication.class, args);
	}

}
@PostConstruct
public void init() {fileSystemStorageService.init()}
}