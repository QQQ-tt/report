package com.qtx.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qtx.report.entity.SysRole;
import com.qtx.report.mapper.SysRoleMapper;
import com.qtx.report.service.ISysRoleService;
import com.qtx.report.utils.NumUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-09-13
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public boolean saveOrUpdateNew(SysRole sysRole) {
        sysRole.setRoleId(NumUtils.uuid());
        return saveOrUpdate(sysRole);
    }
}
