package com.qtx.report.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author qtx
 * @date 2022/9/15 20:43
 */
@Data
public class RoleUrlsDto {

    private String roleId;

    private List<String> urlIds;
}
