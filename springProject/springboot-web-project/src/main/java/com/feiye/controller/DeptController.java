package com.feiye.controller;

import com.feiye.pojo.Dept;
import com.feiye.pojo.Result;
import com.feiye.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ReusableMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-14 17:17
 * @className DeptController
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    // private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)   // 指定请求方式为GET
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        // 调用service删除部门
        deptService.delete(id);

        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门: {}", dept);
        // 调用service新增部门
        deptService.add(dept);

        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result listById(@PathVariable Integer id) {
        log.info("根据id查询部门: {}", id);
        // 调用service查询部门
        List<Dept> deptList = deptService.listById(id);

        return Result.success(deptList);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门: {}", dept);
        deptService.update(dept);

        return Result.success();
    }
}
