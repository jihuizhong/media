package com.example.media.controller;


import com.example.media.service.intf.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author JiHuizhong
 * @since 2020-12-20
 */
@RestController
@RequestMapping(value = "/v1/file")
public class FileManagementController {

    @Autowired
    private FileManagementService fileManagementService;

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        boolean result = fileManagementService.uploadFile(file, request);
        if (!result) {
            return "上传失败";
        }
        return "上传成功";
    }

    @RequestMapping("/getFileList")
    public List<String> getFileList(){
        return null;
    }
}
