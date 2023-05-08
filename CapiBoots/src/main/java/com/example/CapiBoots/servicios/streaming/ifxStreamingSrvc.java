package com.example.CapiBoots.servicios.streaming;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

public interface ifxStreamingSrvc {

    Mono<Resource> getVideo(String title);
}
