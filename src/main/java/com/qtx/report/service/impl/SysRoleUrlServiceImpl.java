package com.qtx.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qtx.report.entity.SysRoleUrl;
import com.qtx.report.mapper.SysRoleUrlMapper;
import com.qtx.report.pojo.bo.RoleUrlBo;
import com.qtx.report.pojo.dto.RoleUrlsDto;
import com.qtx.report.service.ISysRoleUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色地址关系表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Service
public class SysRoleUrlServiceImpl extends ServiceImpl<SysRoleUrlMapper, SysRoleUrl> implements ISysRoleUrlService {

    @Autowired
    private SysRoleUrlMapper mapper;

    public List<RoleUrlBo> getRoleUrlAll() {
        return mapper.selectRoleUrlDto();
    }

    @Override
    public boolean addUrlWithRole(RoleUrlsDto dto) {
        List<SysRoleUrl> list = new ArrayList<>();
        dto.getUrlIds().forEach(e -> list.add(SysRoleUrl.builder().roleId(dto.getRoleId()).urlId(e).build()));
        return saveOrUpdateBatch(list);
    }
}
