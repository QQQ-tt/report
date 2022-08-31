package com.fry.report.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fry.report.entity.InvoiceRecords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fry.report.vo.InvoiceRecordsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 发票记录表 Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2022-08-31
 */
@Mapper
public interface InvoiceRecordsMapper extends BaseMapper<InvoiceRecords> {
    /**
     * 分页查询
     *
     * @param page         分页参数
     * @param queryWrapper 查询条件
     * @return 分页集合
     */
    Page<InvoiceRecordsVo> selectPageNew(Page<InvoiceRecordsVo> page,
                                         @Param(Constants.WRAPPER) LambdaQueryWrapper<InvoiceRecords> queryWrapper);
}
