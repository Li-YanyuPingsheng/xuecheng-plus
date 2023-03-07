package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;

import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2023-03-04 21:59
 * @Description 功能描述
 */
public interface TeachplanService {
    List<TeachplanDto> findTeachplayTree(Long courseId);

    void saveTeachplan(SaveTeachplanDto saveTeachplanDto);
}
