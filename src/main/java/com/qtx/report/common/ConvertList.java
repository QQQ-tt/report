package com.qtx.report.common;

import java.util.List;

/**
 * @author: QTX
 * @date: 2022/5/24
 */
public interface ConvertList<E> {

    /**
     * excel与数据库不一致，手动实现转换方式
     *
     * @param list
     * @return
     */
    List<E> convert(List<E> list);
}
