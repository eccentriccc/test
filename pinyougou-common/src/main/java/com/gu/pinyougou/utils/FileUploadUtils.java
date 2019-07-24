package com.gu.pinyougou.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
public class FileUploadUtils {
    private static final String webServiceUrl = "http://192.168.227.129:8080/";
    private static final String confFileName = "F:\\develop\\java\\Space\\frame\\pinyougou-parent\\pinyougou-common\\src\\main\\resources\\fastdfs_client.conf";
    static {
        try {
            ClientGlobal.init(confFileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String fileUpload(MultipartFile file) {
        StringBuilder sb = new StringBuilder(file.getResource().getFilename());
        String fileSuffix = sb.delete(0, sb.length() - 3).toString();
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(file.getBytes(),fileSuffix,null);
            System.out.println(webServiceUrl + fileIds[0] + "/" + fileIds[1]);
            return webServiceUrl + fileIds[0] + "/" + fileIds[1];
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
