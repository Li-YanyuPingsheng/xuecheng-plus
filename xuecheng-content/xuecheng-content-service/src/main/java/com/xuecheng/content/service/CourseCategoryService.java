package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2023-02-28 20:51
 * @Description 功能描述
 */
public interface CourseCategoryService {

    List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
