package com.feiye.service.impl;

import com.feiye.mapper.DeptLogMapper;
import com.feiye.pojo.DeptLog;
import com.feiye.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-17 13:28
 * @className DeptLogServiceImpl
 * @since 1.0
 */
@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
