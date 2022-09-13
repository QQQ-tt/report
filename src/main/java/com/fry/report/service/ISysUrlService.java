package com.fry.report.service;

import com.fry.report.entity.SysUrl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 请求地址信息表 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
public interface ISysUrlService extends IService<SysUrl> {
    /**
     * 获取所有请求地址
     */
    void addUrlAll();
}
