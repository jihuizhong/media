package com.example.media.comm.util;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {

    public static void uploadFile(byte[] fileContent, String filePath, String fileName) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        FileOutputStream os = new FileOutputStream(filePath + fileName);
        os.write(fileContent);
        os.flush();
        os.close();
    }
}
