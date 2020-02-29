package com.itstyle.cloud.web;

import com.alibaba.fastjson.JSONObject;
import com.itstyle.cloud.entity.FileInfo;
import com.itstyle.cloud.entity.ResponseEntity;
import com.itstyle.cloud.utils.FilePath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author chenchao
 * @Date 23:04 2020/2/27
 * @Description 用户文件列表
 * @Param
 * @return
 **/

@Controller
@RequestMapping("/file")
public class FileListController {

    @ResponseBody
    @RequestMapping("/FileList")
    public Object getFilePathList(@RequestParam("rootPath") String rootPath){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setData(FilePath.getFilePathTree(rootPath));
        responseEntity.setMsg("sussess");
        responseEntity.setStatu(200);
        return JSONObject.toJSON(responseEntity);
    }


    @ResponseBody
    @RequestMapping("/chipList")
    public Object getChipPathList(@RequestParam("rootPath") String rootPath){
        ResponseEntity responseEntity = new ResponseEntity();
        File rootFile = new File(rootPath);
        if (!rootFile.exists()){
            responseEntity.setData(null);
            responseEntity.setMsg("fail,路径不存在");
            responseEntity.setStatu(200);
            return JSONObject.toJSON(responseEntity);
        }
        File[] files = rootFile.listFiles();
        List list = new ArrayList();
        for (File file:files){
            if (file.isDirectory()){
                Date date = new Date(file.lastModified());
                FileInfo fileInfo = new FileInfo(file.getName(),file.isFile()?1:0,date,file.getUsableSpace());
                list.add(fileInfo);
            }
        }
        responseEntity.setData(list);
        responseEntity.setMsg("sussess");
        responseEntity.setStatu(200);
        return JSONObject.toJSON(responseEntity);
    }


}
