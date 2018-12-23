package com.liuyanzhao.blog.controller.common;


import com.liuyanzhao.blog.util.JsonUtils;
import com.liuyanzhao.blog.util.PictureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: yh-parent
 * @description:
 * @author: Mr.Zhang
 * @create: 2018-11-22 17:06
 **/
@Controller
public class ImgUploadController {
//    @Value("${IMG_URL}")
//    private String imgUrl=;
    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String imgUpload(MultipartFile imgFile){
        String imgUrl = "http://114.116.75.252:81/";
//        return JsonUtils.objectToJson(PictureUtil.kindUpload(imgFile,imgUrl));
        return JsonUtils.objectToJson(PictureUtil.ueditorUpload(imgFile,imgUrl));
    }
}
