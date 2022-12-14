package com.qtx.report.controller;

import com.qtx.report.common.ResultObject;
import com.qtx.report.pojo.dto.RoleUrlsDto;
import com.qtx.report.service.ISysRoleUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色地址关系表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/report/sysRoleUrl")
public class SysRoleUrlController {

    @Autowired
    private ISysRoleUrlService sysRoleUrlService;

    @PostMapping("/addUrlWithRole")
    public ResultObject<Boolean> addUrlWithRole(@RequestBody RoleUrlsDto dto) {
        return ResultObject.success(sysRoleUrlService.addUrlWithRole(dto));
    }

}
