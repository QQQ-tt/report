package com.fry.report.service.impl;

import com.fry.report.entity.DataInfo;
import com.fry.report.mapper.DataInfoMapper;
import com.fry.report.service.IDataInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库信息表 服务实现类
 * </p>
 *
 * @author qtx
 * @since 2022-09-03
 */
@Service
public class DataInfoServiceImpl extends ServiceImpl<DataInfoMapper, DataInfo> implements IDataInfoService {

}
