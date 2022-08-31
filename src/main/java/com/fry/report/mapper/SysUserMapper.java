package com.fry.report.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fry.report.dto.SysUserDto;
import com.fry.report.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
