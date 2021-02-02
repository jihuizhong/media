package com.example.media.comm.constant;

import lombok.Getter;

@Getter
public enum ActivityType {
    Competition(0, "competition", "比赛"),
    Activity(1, "activity", "活动"),
    School(2, "school", "校区");

    ActivityType(Integer index, String desc, String chDesc) {
        this.index = index;
        this.desc = desc;
        this.chDesc = chDesc;
    }

    private final Integer index;

    private final String desc;

    private final String chDesc;

    public static String getDescByIndex(Integer index) {
        for (ActivityType activityType : ActivityType.values()) {
            if (index.equals(activityType.getIndex())) {
                return activityType.getDesc();
            }
        }
        return null;
    }
}
