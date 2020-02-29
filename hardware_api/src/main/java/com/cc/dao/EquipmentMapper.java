package com.cc.dao;

import com.cc.entity.EquipmentAndGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName EquipmentMapper
 * @description
 * @Author 陈超
 * @Date 2020/2/29 13:34
 * @Version 1.0
 **/
public interface EquipmentMapper {
    @Select("select * from equipment_group eg where eg.e_id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "eId",column = "e_id"),
            @Result(property = "group_id",column = "group_id")
    })
    EquipmentAndGroup getUserByEquipmentId(@Param("id") String id);
}
