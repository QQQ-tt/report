package com.fry.report.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fry.report.common.enums.DataEnums;
import com.fry.report.common.exception.DateException;
import com.fry.report.common.pojo.BaseEntity;
import com.fry.report.pojo.dto.InvoiceRecordsDto;
import com.fry.report.entity.InvoiceRecords;
import com.fry.report.mapper.InvoiceRecordsMapper;
import com.fry.report.service.IInvoiceRecordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fry.report.utils.ExcelTransfer;
import com.fry.report.pojo.vo.InvoiceRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 发票记录表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-08-31
 */
@Service
public class InvoiceRecordsServiceImpl extends ServiceImpl<InvoiceRecordsMapper, InvoiceRecords> implements IInvoiceRecordsService {

    @Autowired
    private InvoiceRecordsMapper invoiceRecordsMapper;

    @Autowired
    private ExcelTransfer<InvoiceRecords> excelTransfer;

    @Override
    public IPage<InvoiceRecordsVo> findPage(InvoiceRecordsDto dto) {
        return invoiceRecordsMapper.selectPageNew(new Page<>(dto.getNum(), dto.getSize()),
                Wrappers.lambdaQuery(InvoiceRecords.class)
                        .eq(BaseEntity::getDeleteFlag, "0")
                        .like(dto.getTicketCode() != null, InvoiceRecords::getTicketCode, dto.getTicketCode())
                        .like(dto.getTicketNumber() != null, InvoiceRecords::getTicketNumber, dto.getTicketNumber())
                        .like(dto.getProcessNumber() != null, InvoiceRecords::getProcessNumber, dto.getProcessNumber())
                        .like(StringUtils.isNotBlank(dto.getReimbursementPerson()),
                                InvoiceRecords::getReimbursementPerson,
                                dto.getReimbursementPerson())
                        .between(dto.getStartTime() != null && dto.getEndTime() != null,
                                InvoiceRecords::getBillingDate,
                                dto.getStartTime(),
                                dto.getEndTime()));
    }

    @Override
    public boolean saveOrUpdateNew(InvoiceRecords info) throws DateException {
        boolean flag;
        try {
            flag = saveOrUpdate(info);
        } catch (Exception e) {
            throw new DateException(DataEnums.DATA_INSERT_FAIL);
        }
        return flag;
    }

    @Override
    public void exportExcel(HttpServletResponse response) throws ClassNotFoundException {
        excelTransfer.exportExcel(response, list(), "发票记录表", "sheet", this);
    }
}
