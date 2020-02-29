package com.itstyle.cloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author chenchao
 * @Date 23:18 2020/2/27
 * @Description
 * @Param
 * @return
 **/

@Data
@NoArgsConstructor
public class FileInfo implements Serializable {
    private String name;
    private Integer type;//文件1，路径0
    private Date date;
    private long size;
    private String introduce;
    private List list = null;

    public void setList(List list) {
        this.list = list;
    }

    public FileInfo(String name, Integer type, Date date, long size){
        this.name = name;
        this.type = type;
        this.date = date;
        this.size = size;
    }
}
