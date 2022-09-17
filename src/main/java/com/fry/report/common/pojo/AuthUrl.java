package com.fry.report.common.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * @author qtx
 * @date 2022/9/15 21:51
 */
@Data
@Deprecated
public class AuthUrl {

    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthUrl authUrl = (AuthUrl) o;

        return Objects.equals(url, authUrl.url);
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }
}
