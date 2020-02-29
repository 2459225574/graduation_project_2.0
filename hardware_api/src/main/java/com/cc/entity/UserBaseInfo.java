package com.cc.entity;


import lombok.Data;

@Data
public class UserBaseInfo {

  private String id;
  private String name;
  private String nickName;
  private String sex;
  private long age;
  private String idCardNo;
  private String telephone;
  private String email;
  private String password;

}
