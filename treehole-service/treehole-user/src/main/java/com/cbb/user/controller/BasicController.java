package com.cbb.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "swagger测试")
@RestController
@RequestMapping("/v1/api/test")
public class BasicController {
    @GetMapping("/getTest")
    @Operation(summary = "测试swagger是否可用")
    public String test(@RequestParam("name") String name) {
        return "hello" + name;
    }
}
