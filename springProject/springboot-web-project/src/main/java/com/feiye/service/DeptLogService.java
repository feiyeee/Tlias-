package com.feiye.service;

import com.feiye.pojo.DeptLog;

/**
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-17 13:27
 * @className DeptLogService
 * @since 1.0
 */
public interface DeptLogService {

    /**
     * 添加删除部门的日志
     * @param deptLog
     */
    void insert(DeptLog deptLog);
}
