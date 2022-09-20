package com.qtx.report.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author qtx
 * @date 2022/9/15 20:43
 */
@Data
@Accessors(chain = true)
public class UserRolesDto {

    private Integer card;

    private List<String> roleIds;
}
