package com.feiye.service;

import com.feiye.pojo.Emp;
import com.feiye.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-14 17:21
 * @className EmpService
 * @since 1.0
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page,Integer pageSize, String name, Short gender,LocalDate begin,LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工
     * @param emp
     */
    void add(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp pageById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
