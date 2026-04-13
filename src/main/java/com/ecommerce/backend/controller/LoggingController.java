package com.ecommerce.backend.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logging")
public class LoggingController {


    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingController.class);
    @GetMapping("/v1")
    public ResponseEntity<String> testLogging(){
        LOGGER.trace("🔍 TRACE: This is a very detailed trace log. Used for tracking execution flow.");
        LOGGER.debug("🐞 DEBUG: This is a debug message. Used for debugging.");
        LOGGER.info("ℹ️ INFO: This is an informational message. Application events.");
        LOGGER.warn("⚠️ WARN: This is a warning! Something might go wrong.");
        LOGGER.error("🚨 ERROR: An error occurred! This needs immediate attention.");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Logging Successful");
    }
}
