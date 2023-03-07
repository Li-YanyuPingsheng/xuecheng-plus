package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import lombok.Data;

import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2023-03-04 21:35
 * @Description 功能描述
 */
@Data
public class TeachplanDto extends Teachplan {
    TeachplanMedia teachplanMedia;

    List<TeachplanDto> teachPlanTreeNodes;
}
