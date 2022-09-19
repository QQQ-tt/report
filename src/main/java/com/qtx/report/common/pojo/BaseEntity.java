package com.qtx.report.common.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
@Data
public class BaseEntity {
    @TableId
    @ExcelIgnore
    private Long id;

    @ExcelProperty("创建数据的用户")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ExcelIgnore
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ExcelProperty("修改数据的用户")
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    @ExcelIgnore
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ExcelIgnore
    private Integer deleteFlag;
}
