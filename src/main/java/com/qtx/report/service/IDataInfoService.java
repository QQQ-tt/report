package com.qtx.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qtx.report.entity.DataInfo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 数据库信息表 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-09-03
 */
public interface IDataInfoService extends IService<DataInfo> {

    /**
     * 文件导出
     *
     * @param response
     */
    void exportExcel(HttpServletResponse response) throws IOException;

    /**
     * 文件导出
     *
     * @param response
     */
    void exportExcel1(HttpServletResponse response) throws IOException;

}
