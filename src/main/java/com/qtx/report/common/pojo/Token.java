package com.qtx.report.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

/**
 * @author qtx
 * @date 2022/9/6 22:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String token;
    private String name;
    private User user;
}
