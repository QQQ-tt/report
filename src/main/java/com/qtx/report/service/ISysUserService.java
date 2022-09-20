package com.qtx.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qtx.report.common.exception.DateException;
import com.qtx.report.entity.SysUser;
import com.qtx.report.pojo.dto.CreateSysUserDto;
import com.qtx.report.pojo.dto.SysUserDto;
import com.qtx.report.pojo.dto.SysUserPasswordDto;
import com.qtx.report.pojo.vo.CreateVo;
import com.qtx.report.pojo.vo.LoginVo;
import com.qtx.report.pojo.vo.SysUserVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 登录
     *
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
     * 添加和修改用户
     *
     * @param user 用户实体
     * @return
     */
    boolean saveOrUpdateNew(CreateSysUserDto user);

    /**
     * 退出登录
     *
     * @return
     */
    boolean logout();

    /**
     * 分页查询用户信息
     *
     * @param dto
     * @return
     */
    IPage<SysUserVo> allPage(SysUserDto dto);

    /**
     * 修改密码
     *
     * @param user
     * @return
     *
     * @throws DateException
     */
    boolean changePassword(SysUserPasswordDto user) throws DateException;

    /**
     * 修改装填
     *
     * @param id     用户id
     * @param status 状态码
     * @return
     */
    boolean updateByIdNew(Integer id, Integer status);
}
