package com.qtx.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qtx.report.entity.SysUserRole;
import com.qtx.report.pojo.dto.UserRolesDto;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 赋予用户对应的角色
     *
     * @param dto 用户card和对应角色的id集合
     * @return true or false
     */
    boolean addRoleWithUser(UserRolesDto dto);

    /**
     * 通过用户card获取角色
     *
     * @param card
     * @return
     */
    String getRoleByUser(Integer card);
}
