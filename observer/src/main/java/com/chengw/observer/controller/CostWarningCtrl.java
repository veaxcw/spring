package com.chengw.observer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengw
 */

@RestController
public class CostWarningCtrl {

    @RequestMapping("/")
    public String costStatus(){

        return "测试";
    }

}
