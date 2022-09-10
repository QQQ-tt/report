package com.fry.report.controller;

import com.fry.report.service.ISysUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 请求地址信息表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/report/sysUrl")
public class SysUrlController {

    @Autowired
    private ISysUrlService urlService;

    @GetMapping("/addUrlAll")
    public void addUrlAll(){
        urlService.addUrlAll();
    }

}
