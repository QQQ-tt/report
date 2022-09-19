package com.qtx.report.controller;

import com.qtx.report.common.ResultObject;
import com.qtx.report.pojo.dto.UserRolesDto;
import com.qtx.report.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/report/sysUserRole")
public class SysUserRoleController {

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @PostMapping("/addRoleWithUser")
    public ResultObject<Boolean> addRoleWithUser(@RequestBody UserRolesDto dto) {
        return ResultObject.success(sysUserRoleService.addRoleWithUser(dto));
    }

    @GetMapping("/getRoleByCard/{card}")
    public ResultObject<String> getRoleByCard(@PathVariable Integer card) {
        return ResultObject.success(sysUserRoleService.getRoleByUser(card));
    }
}
