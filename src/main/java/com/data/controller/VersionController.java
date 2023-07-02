package com.data.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	@Value("${app.version}")
	private String appVersion;
	
    @GetMapping("/api/version")
    public String getVersion() {
        return appVersion;
    }
}
