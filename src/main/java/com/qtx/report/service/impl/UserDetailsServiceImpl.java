package com.qtx.report.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qtx.report.entity.SysUser;
import com.qtx.report.mapper.SysUserMapper;
import com.qtx.report.service.ISysUserRoleService;
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

    public static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser one = sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class)
                .eq(SysUser::getCard, username)
                .eq(SysUser::getStatus, "0"));
        if (Objects.isNull(one)) {
            throw new UsernameNotFoundException("用户为空");
        }
        LOCAL.set(one.getName());
        List<GrantedAuthority> list =
                AuthorityUtils.commaSeparatedStringToAuthorityList(sysUserRoleService.getRoleByUser(
                one.getCard()));
        return new User(String.valueOf(one.getCard()), one.getPassword(), list);
    }
}
