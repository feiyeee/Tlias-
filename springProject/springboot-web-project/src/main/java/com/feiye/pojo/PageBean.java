package com.feiye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果封装类
 * @version 1.0
 * @Author feiye
 * @Date 2024-07-15 13:00
 * @className PageBean
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;   // 总记录数
    private List rows;    // 数据列表
}
