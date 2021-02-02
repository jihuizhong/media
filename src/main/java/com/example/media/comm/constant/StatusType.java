package com.example.media.comm.constant;

import lombok.Getter;

@Getter
public enum StatusType {
    DOING(0, "doing", "进行中"),
    FINISHED(1, "finished", "已结束");

    StatusType(Integer index, String desc, String chDesc) {
        this.index = index;
        this.desc = desc;
        this.chDesc = chDesc;
    }

    private final Integer index;

    private final String desc;

    private final String chDesc;

    public static String getDescByIndex(Integer index) {
        for (StatusType activityType : StatusType.values()) {
            if (index.equals(activityType.getIndex())) {
                return activityType.getDesc();
            }
        }
        return null;
    }
}
