package com.fry.report.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fry.report.entity.SysUser;
import com.fry.report.mapper.SysUserMapper;
import com.fry.report.service.ISysUrlService;
import com.fry.report.service.ISysUserRoleService;
import com.fry.report.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser one = sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getCard, username));
        if (Objects.isNull(one)) {
            throw new UsernameNotFoundException("用户为空");
        }
        List<GrantedAuthority> list =
                AuthorityUtils.commaSeparatedStringToAuthorityList(sysUserRoleService.getRoleByUser(
                one.getCard()));
        return new User(String.valueOf(one.getCard()), one.getPassword(), list);
    }
}
