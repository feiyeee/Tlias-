package com.feiye.service;

import com.feiye.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-14 17:20
 * @className DeptService
 * @since 1.0
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    List<Dept> listById(Integer id);


    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);
}
