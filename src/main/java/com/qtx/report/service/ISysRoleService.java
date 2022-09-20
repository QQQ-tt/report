package com.qtx.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qtx.report.entity.SysRole;
import com.qtx.report.pojo.vo.SysRoleVo;

import java.util.List;

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

    /**
     * 获取全部角色
     *
     * @return 角色集合
     */
    List<SysRoleVo> listAll();
}
