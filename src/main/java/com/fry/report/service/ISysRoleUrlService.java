package com.fry.report.service;

import com.fry.report.entity.SysRoleUrl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fry.report.pojo.dto.RoleUrlsDto;

/**
 * <p>
 * 角色地址关系表 服务类
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
public interface ISysRoleUrlService extends IService<SysRoleUrl> {

    /**
     * 赋予角色url的访问权限
     * @param dto 角色id和对应url的id集合
     * @return true or false
     */
    boolean addUrlWithRole(RoleUrlsDto dto);
}
