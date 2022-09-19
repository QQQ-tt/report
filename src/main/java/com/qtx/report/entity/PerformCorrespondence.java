package com.qtx.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qtx.report.common.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 数据执行对应关系
 * </p>
 *
 * @author qtx
 * @since 2022-09-03
 */
@Getter
@Setter
@TableName("perform_correspondence")
public class PerformCorrespondence extends BaseEntity {

    /**
     * 查询数据源id
     */
    @TableField("data_info_id_select")
    private Integer dataInfoIdSelect;

    /**
     * 目标数据源id
     */
    @TableField("data_info_id_insert")
    private Integer dataInfoIdInsert;

    /**
     * 查询sql
     */
    @TableField("select_sql")
    private String selectSql;

    /**
     * 插入sql
     */
    @TableField("insert_sql")
    private String insertSql;
}
