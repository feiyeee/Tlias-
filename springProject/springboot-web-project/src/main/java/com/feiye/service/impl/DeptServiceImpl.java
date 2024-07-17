package com.feiye.service.impl;

import com.feiye.mapper.DeptLogMapper;
import com.feiye.mapper.DeptMapper;
import com.feiye.mapper.EmpMapper;
import com.feiye.pojo.Dept;
import com.feiye.pojo.DeptLog;
import com.feiye.service.DeptLogService;
import com.feiye.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-14 17:21
 * @className DeptServiceImpl
 * @since 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)  // Spring事务管理
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id);  // 根据ID删除部门数据

            //int i = 1/0;

            empMapper.deleteByDeptId(id);  // 根据部门ID删除部门下的员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public List<Dept> listById(Integer id) {
        return deptMapper.listById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);

    }
}
