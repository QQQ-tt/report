package com.qtx.report.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qtx.report.common.CommonMethod;
import com.qtx.report.common.enums.DataEnums;
import com.qtx.report.common.exception.DateException;
import com.qtx.report.common.pojo.Token;
import com.qtx.report.entity.SysUser;
import com.qtx.report.mapper.SysUserMapper;
import com.qtx.report.pojo.dto.SysUserDto;
import com.qtx.report.pojo.dto.SysUserPasswordDto;
import com.qtx.report.pojo.vo.CreateVo;
import com.qtx.report.pojo.vo.LoginVo;
import com.qtx.report.service.ISysUserService;
import com.qtx.report.utils.JwtUtils;
import com.qtx.report.utils.NumUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CommonMethod commonMethod;

    @Override
    public LoginVo login(SysUser user) throws DateException {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user.getCard(),
                user.getPassword());
        Authentication authenticate;
        try {
            authenticate = manager.authenticate(auth);
        } catch (RuntimeException e) {
            throw new DateException(DataEnums.USER_IS_FAIL);
        }

        User principal = (User) authenticate.getPrincipal();
        principal.eraseCredentials();
        String username = principal.getUsername();
        String token = jwtUtils.generateToken(username);
        ThreadLocal<String> local = UserDetailsServiceImpl.LOCAL;
        String s = local.get();
        local.remove();
        jwtUtils.TOKEN.put(username, new Token(token, s, principal));
        log.info("token map :{}", jwtUtils.TOKEN);
        return new LoginVo().setToken(token).setName(s);
    }

    @Override
    public CreateVo createUser(SysUser user) throws DateException {
        String password = user.getPassword();
        if (StringUtils.isBlank(user.getName()) && StringUtils.isBlank(password)) {
            throw new DateException(DataEnums.DATA_IS_NULL);
        }
        Set<Integer> set = list().stream().map(SysUser::getCard).collect(Collectors.toSet());
        boolean flag;
        do {
            Integer s = NumUtils.numUserCard();
            flag = set.contains(s);
            if (!flag) {
                user.setCard(s);
            }
        } while (flag);
        user.setPassword(passwordEncoder.encode(password));
        if (save(user)) {
            return new CreateVo(user.getName(), user.getCard(), password);
        } else {
            throw new DateException(DataEnums.DATA_INSERT_FAIL);
        }
    }

    @Override
    public boolean logout() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = user.getUsername();
        return jwtUtils.TOKEN.remove(s) != null;
    }

    @Override
    public IPage<SysUser> allPage(SysUserDto dto) {
        return page(new Page<>(dto.getNum(), dto.getSize()),
                Wrappers.lambdaQuery(SysUser.class)
                        .like(dto.getCard() != null, SysUser::getCard, dto.getCard())
                        .like(StringUtils.isNotBlank(dto.getName()), SysUser::getName, dto.getName()));
    }

    @Override
    public boolean changePassword(SysUserPasswordDto user) throws DateException {
        String password = user.getOldPassword();
        String s = commonMethod.getUser().getUsername();
        String oldPassword = getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getCard, s)).getPassword();
        if (!passwordEncoder.matches(password, oldPassword)) {
            throw new DateException(DataEnums.WRONG_PASSWORD);
        }
        return update(Wrappers.lambdaUpdate(SysUser.class)
                .set(SysUser::getPassword, passwordEncoder.encode(user.getNewPassword()))
                .eq(SysUser::getCard, s));
    }
}
