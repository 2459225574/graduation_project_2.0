package com.itstyle.cloud.utils;

import com.itstyle.cloud.entity.FileInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author chenchao
 * @Date 23:07 2020/2/27
 * @Description
 * @Param
 * @return
 **/
public class FilePath {

    public static List getFilePathTree(String rootPath){
        File rootFile = new File(rootPath);
        if (!rootFile.exists()){
            return null;
        }
        List list = new ArrayList();
        Date date = null;
        File[] files = rootFile.listFiles();
        if (files.length>0){
            for (File file:files){
                date = new Date(file.lastModified());
                FileInfo fileInfo = new FileInfo(file.getName(),file.isFile()?1:0,date,file.getUsableSpace());
                if (file.isDirectory())
                    fileInfo.setList(getFilePathTree(file.getAbsolutePath()));
                list.add(fileInfo);
            }
        }
        return list;
    }

}
