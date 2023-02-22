package com.xuecheng.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Author LiMingYu
 * @Create 2023-02-22 21:08
 * @Description 功能描述
 */
@Data
@ToString
public class QueryCourseParamsDto {
    //审核状态
    private String auditStatus;
    //课程名称
    private String courseName;
    //发布状态
    private String publishStatus;
}
