package com.example.media.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author JiHuizhong
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ActivityManagement extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String activityName;

    private String creator;

    private LocalDateTime beginTime;

    private LocalDateTime finishTime;

    private String message;

    private Integer activityType;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private LocalDateTime endTime;

    private Boolean isDelete;


}
