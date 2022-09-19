package com.qtx.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qtx.report.common.exception.DateException;
import com.qtx.report.entity.InvoiceRecords;
import com.qtx.report.pojo.dto.InvoiceRecordsDto;
import com.qtx.report.pojo.vo.InvoiceRecordsVo;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 发票记录表 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-08-31
 */
public interface IInvoiceRecordsService extends IService<InvoiceRecords> {
    /**
     * 分页查询
     *
     * @param dto 条件信息
     * @return 分页结果
     */
    IPage<InvoiceRecordsVo> findPage(InvoiceRecordsDto dto);

    /**
     * 更新或添加
     *
     * @param info 数据详情
     * @return true or false
     *
     * @throws DateException 数据添加失败
     */
    boolean saveOrUpdateNew(InvoiceRecords info) throws DateException;

    /**
     * 文件导出
     *
     * @param response
     */
    void exportExcel(HttpServletResponse response) throws ClassNotFoundException;
}
