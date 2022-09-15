package com.fry.report.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fry.report.common.ResultObject;
import com.fry.report.common.exception.DateException;
import com.fry.report.pojo.dto.SysUserDto;
import com.fry.report.pojo.dto.SysUserPasswordDto;
import com.fry.report.entity.SysUser;
import com.fry.report.service.impl.SysUserServiceImpl;
import com.fry.report.pojo.vo.CreateVo;
import com.fry.report.pojo.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
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

    @GetMapping("/logout")
    public ResultObject<Boolean> logout(){
        return ResultObject.success(sysUserService.logout());
    }

    @PostMapping("/changePassword")
    public Object changePassword(@RequestBody SysUserPasswordDto user) throws DateException {
        return ResultObject.success(sysUserService.changePassword(user));
    }

    @GetMapping("/all")
    public ResultObject<List<SysUser>> getAll(){
        return ResultObject.success(sysUserService.list());
    }

    @PostMapping("/findPage")
    public ResultObject<IPage<SysUser>> getFindPage(@RequestBody SysUserDto dto){
        return ResultObject.success(sysUserService.allPage(dto));
    }
}
