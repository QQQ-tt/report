package com.fry.report.service.impl;

import com.fry.report.dto.RoleUrlDto;
import com.fry.report.entity.SysRoleUrl;
import com.fry.report.mapper.SysRoleUrlMapper;
import com.fry.report.service.ISysRoleUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
