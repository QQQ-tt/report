package com.qtx.report.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qtx.report.entity.SysUser;
import com.qtx.report.pojo.vo.SysUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页查询
     *
     * @param page         分页参数
     * @param queryWrapper 查询条件
     * @return 分页集合
     */
    Page<SysUserVo> selectPageNew(Page<SysUserVo> page,
                                  @Param(Constants.WRAPPER) LambdaQueryWrapper<SysUser> queryWrapper);
}
