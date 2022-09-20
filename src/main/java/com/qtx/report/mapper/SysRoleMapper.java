package com.qtx.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qtx.report.entity.SysRole;
import com.qtx.report.pojo.vo.SysRoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2022-09-13
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVo> listVo();
}
