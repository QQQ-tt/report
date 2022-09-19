package com.qtx.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qtx.report.entity.SysUserRole;
import com.qtx.report.mapper.SysUserRoleMapper;
import com.qtx.report.pojo.dto.UserRolesDto;
import com.qtx.report.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper mapper;

    @Override
    public boolean addRoleWithUser(UserRolesDto dto) {
        List<SysUserRole> list = new ArrayList<>();
        dto.getRoleIds().forEach(e -> list.add(SysUserRole.builder().userCard(dto.getCard()).roleId(e).build()));
        return saveOrUpdateBatch(list);
    }

    @Override
    public String getRoleByUser(Integer card) {
        List<String> strings = mapper.selectRoleByUserCard(card);
        StringBuilder builder = new StringBuilder();
        if (strings.size() == 0) {
            return "";
        }
        for (int i = 0; ; i++) {
            builder.append(strings.get(i));
            if (i == strings.size() - 1) {
                return builder.toString();
            }
            builder.append(",");
        }
    }
}
