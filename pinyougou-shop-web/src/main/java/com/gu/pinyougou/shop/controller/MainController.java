package com.gu.pinyougou.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {
    @RequestMapping("username")
    public String getUserName(Principal principal){
        return principal.getName();
    }
}
