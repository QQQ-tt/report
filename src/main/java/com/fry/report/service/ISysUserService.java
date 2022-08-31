package com.fry.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fry.report.common.exception.DateException;
import com.fry.report.dto.SysUserDto;
import com.fry.report.dto.SysUserPasswordDto;
import com.fry.report.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fry.report.vo.CreateVo;
import com.fry.report.vo.LoginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 登录
     * @param user 用户信息
     * @return
     */
    LoginVo login(SysUser user) throws DateException;

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return
     */
    CreateVo createUser(SysUser user) throws DateException;

    /**
     * 退出登录
     * @return
     */
    boolean logout();

    /**
     * 分页查询用户信息
     * @param dto
     * @return
     */
    IPage<SysUser> allPage(SysUserDto dto);

    boolean changePassword(SysUserPasswordDto user) throws DateException;
}
