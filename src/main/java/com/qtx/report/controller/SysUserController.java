package com.qtx.report.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qtx.report.common.ResultObject;
import com.qtx.report.common.exception.DateException;
import com.qtx.report.entity.SysUser;
import com.qtx.report.pojo.dto.CreateSysUserDto;
import com.qtx.report.pojo.dto.SysUserDto;
import com.qtx.report.pojo.dto.SysUserPasswordDto;
import com.qtx.report.pojo.vo.CreateVo;
import com.qtx.report.pojo.vo.LoginVo;
import com.qtx.report.pojo.vo.SysUserVo;
import com.qtx.report.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
@RestController
@RequestMapping("/report/sysUser")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @PostMapping("/login")
    public ResultObject<LoginVo> login(@RequestBody SysUser user) throws DateException {
        return ResultObject.success(sysUserService.login(user));
    }

    @PostMapping("/createUser")
    public ResultObject<CreateVo> createUser(@RequestBody SysUser user) throws DateException {
        return ResultObject.success(sysUserService.createUser(user));
    }

    @PostMapping("/renew")
    public ResultObject<Boolean> renew(@RequestBody CreateSysUserDto user) {
        return ResultObject.success(sysUserService.saveOrUpdateNew(user));
    }

    @GetMapping("/replaceStatus")
    public Object replaceStatus(@RequestParam Integer card, @RequestParam Integer status) {
        return ResultObject.success(sysUserService.updateByIdNew(card, status));
    }

    @GetMapping("/logout")
    public ResultObject<Boolean> logout() {
        return ResultObject.success(sysUserService.logout());
    }

    @PostMapping("/changePassword")
    public Object changePassword(@RequestBody SysUserPasswordDto user) throws DateException {
        return ResultObject.success(sysUserService.changePassword(user));
    }

    @GetMapping("/all")
    public ResultObject<List<SysUser>> getAll() {
        return ResultObject.success(sysUserService.list());
    }

    @PostMapping("/findPage")
    public ResultObject<IPage<SysUserVo>> getFindPage(@RequestBody SysUserDto dto) {
        return ResultObject.success(sysUserService.allPage(dto));
    }

    @DeleteMapping("/remove")
    public ResultObject<Boolean> remove(@RequestParam Long id) {
        return ResultObject.success(sysUserService.removeById(id));
    }
}
