package com.baizhi.service;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.User;
import com.baizhi.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    PageDTO<User> findAllPage(Integer page,Integer rows);
    void updateUser(User user);
    PageDTO<User> queryAllDJ(Integer page, Integer rows);
    /*查询各地区男人数*/
    List<UserVO> queryGroupMan();
    /*查询各地区女人数*/
    List<UserVO> queryGroupFemale();

}
