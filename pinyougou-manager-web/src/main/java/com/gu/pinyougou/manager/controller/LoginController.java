package com.gu.pinyougou.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {
    @RequestMapping("/username")
    public String getUserName(Principal principal){
        return principal.getName();
    }
}
