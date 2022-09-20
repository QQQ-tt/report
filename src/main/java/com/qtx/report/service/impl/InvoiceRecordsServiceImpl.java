package com.qtx.report.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qtx.report.common.enums.DataEnums;
import com.qtx.report.common.exception.DateException;
import com.qtx.report.common.pojo.BaseEntity;
import com.qtx.report.entity.InvoiceRecords;
import com.qtx.report.entity.SysUser;
import com.qtx.report.mapper.InvoiceRecordsMapper;
import com.qtx.report.pojo.dto.InvoiceRecordsDto;
import com.qtx.report.pojo.vo.InvoiceRecordsVo;
import com.qtx.report.service.IInvoiceRecordsService;
import com.qtx.report.utils.ExcelTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
                        .like(StringUtils.isNotBlank(dto.getTicketCode()),
                                InvoiceRecords::getTicketCode,
                                dto.getTicketCode())
                        .like(StringUtils.isNotBlank(dto.getTicketNumber()),
                                InvoiceRecords::getTicketNumber,
                                dto.getTicketNumber())
                        .like(StringUtils.isNotBlank(dto.getProcessNumber()),
                                InvoiceRecords::getProcessNumber,
                                dto.getProcessNumber())
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
        InvoiceRecords one = getOne(Wrappers.lambdaQuery(InvoiceRecords.class)
                .eq(StringUtils.isNotBlank(info.getTicketCode()), InvoiceRecords::getTicketCode, info.getTicketCode())
                .eq(StringUtils.isNotBlank(info.getTicketNumber()),
                        InvoiceRecords::getTicketNumber,
                        info.getTicketNumber()));
        if (Objects.isNull(one)) {
            return saveOrUpdate(info);
        }
        throw new DateException(DataEnums.DATA_INSERT_DUPLICATE);
    }

    @Override
    public void exportExcel(HttpServletResponse response) throws ClassNotFoundException {
        excelTransfer.exportExcel(response, list(), "发票记录表", "sheet", this);
    }

    @Override
    public void exportExcel1(HttpServletResponse response) throws IOException {
        List<SysUser> list = new ArrayList<>();
        list.add(SysUser.builder().card(1).password("11").name("hhh111").build());
        list.add(SysUser.builder().card(2).password("22").name("hhh222").build());
        list.add(SysUser.builder().card(3).password("33").name("hhh333").build());
        list.add(SysUser.builder().card(2).password("44").name("hhh222").build());

        Set<String> set = list.stream().map(SysUser::getName).filter("1"::equals).collect(Collectors.toSet());

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("哈哈哈", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysUser.class)
                .sheet("sheet")
                .registerWriteHandler(new CellWriteHandler() {
                    Integer i = null;

                    @Override
                    public void afterCellDispose(CellWriteHandlerContext context) {
                        //CellWriteHandler.super.afterCellDispose(context);
                        if (BooleanUtils.isNotTrue(context.getHead())) {
                            // 第一个单元格
                            // 只要不是头 一定会有数据 当然fill的情况 可能要context.getCellDataList() ,这个需要看模板，因为一个单元格会有多个 WriteCellData
                            WriteCellData<?> cellData = context.getFirstCellData();
                            WriteCellStyle writeCellStyle = cellData.getOrCreateStyle();
                            // writeCellStyle.getWriteFont().setBold(true);
                            if (set.contains(cellData.getStringValue()) || cellData.getRowIndex().equals(i)) {
                                WriteFont font = new WriteFont();
                                font.setBold(true);
                                writeCellStyle.setWriteFont(font);
                                i = cellData.getRowIndex();
                            }
                        }
                    }
                })
                .doWrite(list);
    }
}
