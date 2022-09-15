package com.fry.report.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.FontProperty;
import com.alibaba.excel.metadata.property.StyleProperty;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.fry.report.entity.DataInfo;
import com.fry.report.entity.SysUser;
import com.fry.report.mapper.DataInfoMapper;
import com.fry.report.service.IDataInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fry.report.utils.ExcelTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据库信息表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-09-03
 */
@Service
public class DataInfoServiceImpl extends ServiceImpl<DataInfoMapper, DataInfo> implements IDataInfoService {

    @Autowired
    private ExcelTransfer<Objects> excelTransfer;

    /**
     * 手动创造数据
     *
     * @param response
     * @throws IOException
     */
    @Override
    public void exportExcel(HttpServletResponse response) throws IOException {
        Map<List<List<String>>, List<List<String>>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<String> list = new ArrayList<>();
            list.add(i + "字段1");
            list.add(i + "字段2");
            list.add(i + "字段3");
            List<List<String>> head = getHead(list);
            List<List<String>> dataes = new ArrayList<>();
            List<String> data = new ArrayList<>();
            data.add("数据1");
            data.add("数据2");
            data.add("数据3");
            dataes.add(data);
            map.put(head, dataes);
        }
        excelTransfer.exportExcel(response, "test", map);
    }

    /**
     * 自定义拦截器
     *
     * @param response
     * @throws IOException
     */
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

    private List<List<String>> getHead(List<String> list) {
        List<List<String>> lists = new ArrayList<>();
        list.forEach(e -> {
            List<String> arrayList = new ArrayList<>();
            arrayList.add(e);
            lists.add(arrayList);
        });
        return lists;
    }
}
