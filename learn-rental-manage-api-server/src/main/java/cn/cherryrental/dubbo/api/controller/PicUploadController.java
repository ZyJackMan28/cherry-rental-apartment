package cn.cherryrental.dubbo.api.controller;

import cn.cherryrental.dubbo.api.service.PicLocalUploadSysService;
import cn.cherryrental.dubbo.api.service.PicUploadService;
import cn.cherryrental.dubbo.api.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("pic/upload")
@Controller
public class PicUploadController {

    @Autowired
    private PicUploadService picUploadService;
    @Autowired
    private PicLocalUploadSysService picLocalUploadSysService;


    /**
     *
     * @param multipartFile
     *
     * 需要参考AntDesign 需要返回什么数据，
     */
    @PostMapping
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file")MultipartFile multipartFile){
        //return this.picUploadService.upload(multipartFile);
        return  this.picLocalUploadSysService.upload(multipartFile);
    }
}
