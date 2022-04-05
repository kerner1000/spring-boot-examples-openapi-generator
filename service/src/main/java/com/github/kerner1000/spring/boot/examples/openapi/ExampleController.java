package com.github.kerner1000.spring.boot.examples.openapi;

import org.openapitools.api.InfoApi;
import org.openapitools.model.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@RestController
public class ExampleController implements InfoApi {

    private final Config config;

    public ExampleController(Config config) {
        this.config = config;
    }

    @Override
    public ResponseEntity<Info> getInfo() {
        if(config.isError()){
            throw new RuntimeException("Error message :(");
        }
        return ResponseEntity.of(Optional.of(new Info().message("Looks good!").date(LocalDateTime.now().atOffset(ZoneOffset.UTC))));
    }
}
