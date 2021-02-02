package com.example.media.comm.constant;

import lombok.Getter;

@Getter
public enum FileType {
    IMAGE(0, "image", "图片"),
    VIDEO(1, "video", "视频");

    FileType(Integer index, String desc, String chDesc) {
        this.index = index;
        this.desc = desc;
        this.chDesc = chDesc;
    }

    private final Integer index;

    private final String desc;

    private final String chDesc;
}
