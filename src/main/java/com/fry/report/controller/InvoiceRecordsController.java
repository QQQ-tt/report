package com.fry.report.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fry.report.common.ResultObject;
import com.fry.report.common.exception.DateException;
import com.fry.report.dto.InvoiceRecordsDto;
import com.fry.report.entity.InvoiceRecords;
import com.fry.report.service.impl.InvoiceRecordsServiceImpl;
import com.fry.report.vo.InvoiceRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 发票记录表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-08-31
 */
@RestController
@RequestMapping("/report/invoiceRecords")
public class InvoiceRecordsController {

    @Autowired
    private InvoiceRecordsServiceImpl invoiceRecordsService;

    @PostMapping("/findPage")
    public ResultObject<IPage<InvoiceRecordsVo>> findPage(@RequestBody InvoiceRecordsDto dto) {
        return ResultObject.success(invoiceRecordsService.findPage(dto));
    }

    @PostMapping("/saveOrUpdate")
    public ResultObject<Boolean> saveOrUpdateInfo(@RequestBody InvoiceRecords info) throws DateException {
        return ResultObject.success(invoiceRecordsService.saveOrUpdateNew(info));
    }

    @PreAuthorize("hasAnyAuthority('role')")
    @DeleteMapping("/remove/{id}")
    public ResultObject<Boolean> remove(@PathVariable Long id) {
        return ResultObject.success(invoiceRecordsService.removeById(id));
    }

    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) throws ClassNotFoundException {
        invoiceRecordsService.exportExcel(response);
    }

}
