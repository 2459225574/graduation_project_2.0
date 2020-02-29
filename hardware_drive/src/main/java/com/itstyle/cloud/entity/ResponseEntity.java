package com.itstyle.cloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenchao
 * @Date 23:42 2020/2/27
 * @Description
 * @Param
 * @return
 **/
@Data
@NoArgsConstructor
public class ResponseEntity {
    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Integer statu;
    private String msg;
    private Object data;
}
