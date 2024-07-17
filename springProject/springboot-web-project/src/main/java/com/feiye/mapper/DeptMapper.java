package com.feiye.mapper;

import com.feiye.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-14 17:18
 * @className DeptMapper
 * @since 1.0
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据ID删除部门
     * @param id
     */
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    /**
     * 插入部门数据
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Select("select * from dept where id=#{id}")
    List<Dept> listById(Integer id);

    // @Update("update dept set name=#{name},createTime=#{createTime},updateTime=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
