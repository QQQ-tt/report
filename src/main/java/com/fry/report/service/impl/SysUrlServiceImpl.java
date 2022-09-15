package com.fry.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fry.report.entity.SysUrl;
import com.fry.report.mapper.SysUrlMapper;
import com.fry.report.service.ISysUrlService;
import com.fry.report.utils.NumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

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
        methodMap.forEach((k, v) -> {
            if (!"[]".equals(k.getMethodsCondition().getMethods().toString())){
                assert k.getPathPatternsCondition() != null;
                Set<PathPattern> set = k.getPathPatternsCondition().getPatterns();
                set.forEach(e -> save(SysUrl.builder()
                        .urlId(NumUtils.uuid())
                        .name(v.getMethod().getName())
                        .bean(v.getBean().toString())
                        .requestType(k.getMethodsCondition().getMethods().toString())
                        .url(e.getPatternString())
                        .build()));
            }
        });
    }
}
