package com.tcaini.cardio.aop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class LogController {

    @GetMapping("/test")
    public Dict test(String who){
        return Dict.create().set("who", StrUtil.isBlank(who)?"me":who);
    }

}
