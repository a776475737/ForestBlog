package com.liuyanzhao.blog.util;


import com.liuyanzhao.blog.dto.ResultVO;
import com.liuyanzhao.blog.dto.UploadFileVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: yh-parent
 * @description:
 * @author: Mr.Zhang
 * @create: 2018-11-22 18:57
 **/
public class PictureUtil {
    public static ResultVO imgUpload(MultipartFile uploadFile, String imgUrl){
        ResultVO resultVO = new ResultVO();
        if (uploadFile!=null){
            try {
                FastDFSClient client = new FastDFSClient("classpath:client.conf");
                String filename = uploadFile.getOriginalFilename();
                String suffix = filename.substring(filename.lastIndexOf(".")+1);
                String url = client.uploadFile(uploadFile.getBytes(),suffix);
                url=imgUrl+url;
                resultVO.setCode(0);
                resultVO.setMsg("上传成功");
                UploadFileVO uploadFileVO = new UploadFileVO();
                uploadFileVO.setTitle(filename);
                uploadFileVO.setSrc(url);
                resultVO.setData(uploadFileVO);
            } catch (Exception e) {
                resultVO.setCode(1);
                resultVO.setMsg("上传失败！");
//                e.printStackTrace();
            }
        }else {
            resultVO.setCode(1);
            resultVO.setMsg("上传文件为空！");
        }
        return resultVO;
    }
    public static PictureResult kindUpload(MultipartFile uploadFile, String imgUrl){
        PictureResult result = new PictureResult();
        if (uploadFile!=null){
            try {
                FastDFSClient client = new FastDFSClient("classpath:client.conf");
                String filename = uploadFile.getOriginalFilename();
                String suffix = filename.substring(filename.lastIndexOf(".")+1);
                String url = client.uploadFile(uploadFile.getBytes(),suffix);
                url=imgUrl+url;
                result.setError(0);
                result.setUrl(url);
            } catch (Exception e) {
                result.setError(1);
                result.setMessage("上传失败");
                e.printStackTrace();
            }
        }else {
            result.setError(1);
            result.setMessage("上传文件为空");
        }
        return result;
    }
    public static PictureUeditorResult ueditorUpload(MultipartFile uploadFile, String imgUrl){
        PictureUeditorResult result = new PictureUeditorResult();
        if (uploadFile!=null){
            try {
                FastDFSClient client = new FastDFSClient("classpath:client.conf");
                String filename = uploadFile.getOriginalFilename();
                String suffix = filename.substring(filename.lastIndexOf(".")+1);
                String url = client.uploadFile(uploadFile.getBytes(),suffix);
                url=imgUrl+url;
                result.setState("SUCCESS");
                result.setUrl(url);
                result.setTitle(filename);
                result.setOriginal(filename);
            } catch (Exception e) {
                result.setState("上传失败！");
            }
        }else {
            result.setState("上传文件为空");
        }
        return result;
    }
}
