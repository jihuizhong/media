package com.example.media.entity.param;

import lombok.Data;

@Data
public class UploadParam {
    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 活动类型
     */
    private Integer activityType;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 文件类型，区分图片、视频
     */
    private Integer fileType;

    /**
     * 上传者
     */
    private String uploaderName;
}
