package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 皇甫
 * @param <T>
 */
public interface BackDao<T> {
    /**查询所有
     *
     * @return
     */
    List<T> findAll();

    /**查询所有并分页
     *
     * @param page
     * @param rows
     * @return
     */
    List<T> finAllPage(@Param("page")Integer page,@Param("rows")Integer rows);

    /**查询总数
     *
     * @return
     */
    Integer findTotalCount();

    /**添加数据
     *
     * @param t
     */
    void addData(T t);

    /**修改数据
     *
     * @param t
     */
    void updateData(T t);

    /**删除数据
     *
     * @param id
     */
    void removeOneById(String id);
}
