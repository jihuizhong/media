package com.example.media.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class FileManagement extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String filePath;

    private LocalDateTime createTime;

    private String createUser;

    private Boolean isDeleted;

    private Integer activityId;


}
