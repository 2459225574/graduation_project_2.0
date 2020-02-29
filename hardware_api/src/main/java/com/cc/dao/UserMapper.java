package com.cc.dao;

import com.cc.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author chenchao
 * @Date 12:50 2020/2/29
 * @Description
 * @Param
 * @return
 **/
public interface UserMapper {
    @Select("SELECT * FROM user_base_info")
    List<UserBaseInfo> getAll();
}
