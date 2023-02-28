package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2023-02-28 20:52
 * @Description 功能描述
 */
@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        //定义返回数据
        List<CourseCategoryTreeDto> courseCategoryTreeDtoList = new ArrayList<>();

        HashMap<String, CourseCategoryTreeDto> nodeMap = new HashMap<>();

        //数据封装如list中，只有根节点的直接下节点
        courseCategoryTreeDtos.stream().forEach(e -> {
            nodeMap.put(e.getId(), e);
            if (e.getParentid().equals(id)) {
                courseCategoryTreeDtoList.add(e);
            }
            //父节点
            String parentId = e.getParentid();
            //父节点对象
            CourseCategoryTreeDto parentNode = nodeMap.get(parentId);
            if (parentNode != null) {
                List childrenTreeNodes = parentNode.getChildrenTreeNodes();
                if (childrenTreeNodes == null) {
                    parentNode.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                }
                parentNode.getChildrenTreeNodes().add(e);
            }
        });

        return courseCategoryTreeDtoList;
    }

}
