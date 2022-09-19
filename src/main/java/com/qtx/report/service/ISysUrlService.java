package com.qtx.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qtx.report.entity.SysUrl;

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
