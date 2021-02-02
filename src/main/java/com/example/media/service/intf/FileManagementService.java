package com.example.media.service.intf;

import com.example.media.entity.FileManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.media.entity.param.UploadParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JiHuizhong
 * @since 2020-12-20
 */
public interface FileManagementService extends IService<FileManagement> {

    boolean uploadFile(MultipartFile file, HttpServletRequest request);

    UploadParam getUploadParam(HttpServletRequest request);
}
