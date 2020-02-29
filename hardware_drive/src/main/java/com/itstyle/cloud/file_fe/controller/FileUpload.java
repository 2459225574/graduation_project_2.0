package com.itstyle.cloud.file_fe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author chenchao
 * @Date 18:38 2020/2/27
 * @Description
 * @Param
 * @return
 **/
@Controller
@RequestMapping("/file/")
public class FileUpload {
    /*
     * 获取file.html页面
     */
    @RequestMapping("")
    public String file(){
        return "/file.shtml";
    }

    /**
     * 单文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "D:\\cloudFile_other" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }


    /**
     * 多文件上传
     * */
    @ResponseBody
    @RequestMapping(value="multifileUpload",method= RequestMethod.POST)
    public String multifileUpload(HttpServletRequest request){
        String path = "D:\\cloudFile_other" ;
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("fileName");

        if (files.size()<=1){ //如果是一个文件
            return oneFileUpload(files.get(0),path);
        }
        if(files.isEmpty()){
            return "false";
        }

        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);
            if(file.isEmpty()){
                return "false";
            }else{
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        return "true";
    }


    public String oneFileUpload(MultipartFile file,String path){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
