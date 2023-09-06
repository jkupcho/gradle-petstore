package com.jkupcho.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PetstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetstoreApplication.class, args);
    }

    @RestController
    static class EchoController {

        @GetMapping("/echo")
        public Echo getEcho(@RequestParam("message") String message) {
            return new Echo(message);
        }

    }

    record Echo(String message) {}
}