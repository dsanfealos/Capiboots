/*
package com.example.CapiBoots.servicios.streaming;

import com.example.CapiBoots.servicios.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class StreamingSrvcImpls implements ifxStreamingSrvc {
    private static final String FORMAT= "classpath:videos/%s.mp4";

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String fileName) {
        return Mono.fromSupplier(() -> resourceLoader.
                getResource(String.format(FORMAT, fileName))) ;

    }
}
*/
