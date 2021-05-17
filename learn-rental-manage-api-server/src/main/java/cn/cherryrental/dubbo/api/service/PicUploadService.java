package cn.cherryrental.dubbo.api.service;

import cn.cherryrental.dubbo.api.config.AliyunConfig;
import cn.cherryrental.dubbo.api.vo.PicUploadResult;
import com.aliyun.oss.OSS;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@Service
public class PicUploadService {

    @Autowired
    private OSS ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;

    //
    private static final String[] IMAGE_TYPE = new String[]{".bmp",".jpg",".jpeg",".gif",".png"};

    public PicUploadResult upload(MultipartFile multipartFile) {
        //校验
        boolean flag = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), type)) {
                flag = true;
                break;
            }
        }
        PicUploadResult fileUploadeResult = new  PicUploadResult();

        //
        if (!flag){
            fileUploadeResult.setStatus("error");
            return fileUploadeResult;
        }
        //上传的文件路径
        String fileName = multipartFile.getOriginalFilename();
        String filePath = getFilePath(fileName);

        // oss
        try {
            //oss 文件目录结构 images/2018/12/29/xxxx.jpg
            ossClient.putObject(aliyunConfig.getBucketName(), filePath,new
                    ByteArrayInputStream(multipartFile.getBytes()));
        }catch (Exception e){
            fileUploadeResult.setStatus("error");
            return fileUploadeResult;
        }
        fileUploadeResult.setStatus("done");
        fileUploadeResult.setName(this.aliyunConfig.getUrlPrefix() + filePath);
        fileUploadeResult.setUid(String.valueOf(System.currentTimeMillis()));
        return null;
    }

    private String getFilePath(String fileName) {
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy")
                +"/" + dateTime.toString("MM") + "/" + dateTime.toString("dd")
                + "/" + System.currentTimeMillis() + RandomUtils.nextInt(100,9999) + "."
                +StringUtils.substringAfterLast(fileName,".");
    }
}
