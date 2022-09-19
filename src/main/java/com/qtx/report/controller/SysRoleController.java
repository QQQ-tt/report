package com.qtx.report.controller;

import com.qtx.report.common.ResultObject;
import com.qtx.report.entity.SysRole;
import com.qtx.report.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-09-13
 */
@RestController
@RequestMapping("/report/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl service;

    @PostMapping("/saveOrUpdate")
    public ResultObject<Boolean> saveOrUpdateNew(@RequestBody SysRole sysRole) {
        return ResultObject.success(service.saveOrUpdateNew(sysRole));
    }

}
