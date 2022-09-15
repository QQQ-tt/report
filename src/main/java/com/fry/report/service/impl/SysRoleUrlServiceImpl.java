package com.fry.report.service.impl;

import com.fry.report.pojo.bo.RoleUrlBo;
import com.fry.report.entity.SysRoleUrl;
import com.fry.report.mapper.SysRoleUrlMapper;
import com.fry.report.pojo.dto.RoleUrlsDto;
import com.fry.report.service.ISysRoleUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
