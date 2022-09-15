package com.fry.report.service.impl;

import com.fry.report.entity.SysRole;
import com.fry.report.mapper.SysRoleMapper;
import com.fry.report.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fry.report.utils.NumUtils;
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
