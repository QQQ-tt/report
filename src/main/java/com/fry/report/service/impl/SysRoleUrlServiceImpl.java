package com.fry.report.service.impl;

import com.fry.report.pojo.dto.RoleUrlDto;
import com.fry.report.entity.SysRoleUrl;
import com.fry.report.mapper.SysRoleUrlMapper;
import com.fry.report.service.ISysRoleUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<RoleUrlDto> getRoleUrlAll(){
        return mapper.selectRoleUrlDto();
    }

}
