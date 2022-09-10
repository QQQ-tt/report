package com.fry.report.service.impl;

import com.fry.report.entity.SysUrl;
import com.fry.report.mapper.SysUrlMapper;
import com.fry.report.service.ISysUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 请求地址信息表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Service
public class SysUrlServiceImpl extends ServiceImpl<SysUrlMapper, SysUrl> implements ISysUrlService {

    @Autowired
    private WebApplicationContext applicationContext;

    @Override
    public void addUrlAll() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 拿到Handler适配器中的全部方法
        Map<RequestMappingInfo, HandlerMethod> methodMap = mapping.getHandlerMethods();
        methodMap.forEach((k,v)->{
            assert k.getPathPatternsCondition() != null;
            Set<PathPattern> set = k.getPathPatternsCondition().getPatterns();
            // 获取全部请求方式
            Set<RequestMethod> methods = k.getMethodsCondition().getMethods();
            set.forEach(e-> save(SysUrl.builder().name(v.getMethod().getName()).url(e.getPatternString()).build()));
        });
    }
}
