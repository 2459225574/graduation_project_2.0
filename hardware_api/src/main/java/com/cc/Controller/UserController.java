package com.cc.Controller;

import com.cc.dao.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenchao
 * @Date 11:38 2020/2/29
 * @Description
 * @Param
 * @return
 **/
@Controller
public class UserController {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        return equipmentMapper.getUserByEquipmentId("12345678");
    }

    @RequestMapping("/index1")
    public String getIndex(){
        return "index";
    }

}
