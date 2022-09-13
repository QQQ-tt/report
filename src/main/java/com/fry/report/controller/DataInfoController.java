package com.fry.report.controller;

import com.fry.report.service.IDataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 数据库信息表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-09-03
 */
@RestController
@RequestMapping("/report/dataInfo")
public class DataInfoController {

    @Autowired
    private IDataInfoService iDataInfoService;

    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        iDataInfoService.exportExcel(response);
    }

}
