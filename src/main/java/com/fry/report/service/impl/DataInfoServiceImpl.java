package com.fry.report.service.impl;

import com.fry.report.entity.DataInfo;
import com.fry.report.mapper.DataInfoMapper;
import com.fry.report.service.IDataInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fry.report.utils.ExcelTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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

    @Override
    public void exportExcel(HttpServletResponse response) throws IOException {
        Map<List<List<String>>, List<List<String>>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<String> list = new ArrayList<>();
            list.add(i+"字段1");
            list.add(i+"字段2");
            list.add(i+"字段3");
            List<List<String>> head = getHead(list);
            List<List<String>> dataes = new ArrayList<>();
            List<String> data = new ArrayList<>();
            data.add("数据1");
            data.add("数据2");
            data.add("数据3");
            dataes.add(data);
            map.put(head,dataes);
        }
        excelTransfer.exportExcel(response,"test",map);
    }

    private List<List<String>> getHead(List<String> list){
        List<List<String>> lists = new ArrayList<>();
        list.forEach(e->{
            List<String> arrayList = new ArrayList<>();
            arrayList.add(e);
            lists.add(arrayList);
        });
        return lists;
    }
}
