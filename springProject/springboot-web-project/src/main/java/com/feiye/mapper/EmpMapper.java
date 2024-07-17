package com.feiye.mapper;

import com.feiye.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-14 17:18
 * @className EmpMapper
 * @since 1.0
 */
@Mapper
public interface EmpMapper {
/*
    *//**
     * 查询总记录数
     * @return
     *//*
    @Select("select count(*) from emp")
    public Long count();

    *//**
     * 分页查询，获取列表数据
     //* @param start
     //* @param pageSize
     //* @return
     *//*
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);*/

    /**
     * 利用分页插件PageHelper
     * 员工信息查询
     * @return
     */
    // @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工
     * @param emp
     */
    @Insert("insert into " +
            "emp(username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void add(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     */
    @Select("select * from emp where id=#{id}")
    Emp pageById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询员工
     * @param emp
     * @return
     */
    @Select("SELECT * FROM `emp` where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门ID删除该部门下的员工数据
     * @param deptId
     */
    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
