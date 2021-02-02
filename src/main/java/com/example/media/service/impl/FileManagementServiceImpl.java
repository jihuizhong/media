package com.example.media.service.impl;

import com.example.media.comm.constant.ActivityType;
import com.example.media.comm.constant.FileType;
import com.example.media.comm.util.FileUtil;
import com.example.media.entity.ActivityManagement;
import com.example.media.entity.FileManagement;
import com.example.media.entity.param.UploadParam;
import com.example.media.mapper.ActivityManagementMapper;
import com.example.media.mapper.FileManagementMapper;
import com.example.media.service.intf.FileManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author JiHuizhong
 * @since 2020-12-20
 */
@Service
public class FileManagementServiceImpl extends ServiceImpl<FileManagementMapper, FileManagement> implements FileManagementService {

    private static final Logger logger = LoggerFactory.getLogger(FileManagementServiceImpl.class);

    @Value("${path.image}")
    private String imageBasePath;

    @Value("${path.video}")
    private String videoBasePath;

    @Resource
    private ActivityManagementMapper activityManagementMapper;

    @Resource
    private FileManagementMapper fileManagementMapper;

    @Override
    public boolean uploadFile(MultipartFile file , HttpServletRequest request) {
        // 解析参数
        UploadParam param = getUploadParam(request);

        // 拼接路径
        String basePath = imageBasePath;
        if (FileType.VIDEO.getIndex().equals(param.getFileType())) {
            basePath = videoBasePath;
        }
        String fileName = file.getOriginalFilename();
        String activityDesc = ActivityType.getDescByIndex(param.getActivityType());
        if (activityDesc == null) {
            logger.error("invalid activity type. fileName=" + fileName);
            return false;
        }

        String filePath = basePath + File.separator + activityDesc + File.separator + param.getActivityName()
                + File.separator;
        boolean result = true;
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            FileManagement fileManagement = new FileManagement();
            fileManagement.setActivityId(param.getActivityId());
            fileManagement.setFilePath(filePath + fileName);
            fileManagement.setCreateUser(param.getUploaderName());
            fileManagementMapper.insert(fileManagement);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public UploadParam getUploadParam(HttpServletRequest request) {
        UploadParam param = new UploadParam();
        String fileType = request.getParameter("fileType");
        String activityId = request.getParameter("activityId");
        String uploaderName = request.getParameter("uploaderName");
        if (fileType != null) {
            param.setFileType(Integer.valueOf(fileType));
        }
        if (activityId != null) {
            ActivityManagement activityManagement = activityManagementMapper.selectById(activityId);
            if (activityManagement != null) {
                param.setActivityId(activityManagement.getId());
                param.setActivityName(activityManagement.getActivityName());
                param.setActivityType(activityManagement.getActivityType());
            }
        }
        param.setUploaderName(uploaderName);
        return param;
    }
}
