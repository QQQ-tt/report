package com.qtx.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qtx.report.entity.SysRoleUrl;
import com.qtx.report.pojo.bo.RoleUrlBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色地址关系表 Mapper 接口
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Mapper
public interface SysRoleUrlMapper extends BaseMapper<SysRoleUrl> {
    /**
     * 根据角色查询url
     *
     * @return url对象集合
     */
    List<RoleUrlBo> selectRoleUrlDto();

}
