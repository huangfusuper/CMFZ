package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BackDao<User>  {
    //查询所有用户连接上师连接功课，连接计数器继承
    //修改状态 冻结用户
    //查看批量冻结
    List<User> queryAllDJ(@Param("page")Integer page, @Param("rows")Integer rows);
    Integer findTotalCountDJ();

    /*查询各地区男人数*/
    List<UserVO> queryGroupMan();
    /*查询各地区女人数*/
    List<UserVO> queryGroupFemale();
    /*批量插入*/
    void addDataAll(User user);
}
