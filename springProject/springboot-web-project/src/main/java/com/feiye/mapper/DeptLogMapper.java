package com.feiye.mapper;

import com.feiye.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-17 13:23
 * @className DeptLogMapper
 * @since 1.0
 */
@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(id, create_time, description) values(#{id},#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
