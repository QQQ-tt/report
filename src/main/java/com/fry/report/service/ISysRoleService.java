package com.fry.report.service;

import com.fry.report.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-09-13
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 新建或更新
     *
     * @param sysRole 角色实体
     * @return true or false
     */
    boolean saveOrUpdateNew(SysRole sysRole);
}
