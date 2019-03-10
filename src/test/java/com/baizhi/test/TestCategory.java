package com.baizhi.test;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCategory {
    @Autowired
    private CategoryDao cd;

    public void setCd(CategoryDao cd) {
        this.cd = cd;
    }

    @Test
    public void test1(){
        List<Category> all = cd.findAll();
        for (Category category : all) {
            System.out.println(category.getName());
            List<Category> categories = category.getCategories();
            for (Category c : categories) {
                System.out.println(c.getName()+"字表");
            }
        }
    }

    /*
    * 01/10/11/100/101/
    *
    * 5转换为2进制为101   按位运算右移一位。忽略符号位>>>位010  即为   2
    * 5转换为2进制为101   按位运算右移二位。忽略符号位>>>位001  即为   1
    *
    * */

    @Test
    public void test2(){
        //二进制为0101
        int n =4;
        /*位运算无符号右移一位   为  0010 为 2  同时与5进行|位运算
        * 0010
        * 0101
        * -----
        * 0111  转化位10进制位  7
        * */
        n |= n>>>1;
        /*
        * n=7   二进制为  0111
        * 无符号右移2位为0001  结果为1
        * 此时与7进行|位运算
        * 0111
        * 0001
        * -----
        * 0110------------------->6
        * */
        n |= n>>>2;
        /*
        * 6----->  0110>>>4  ------------>00000
        * 6
        * 0110
        * 0000
        * 0110---------------->6
        * */
        n |= n>>>4;
        /*
        * 无符号右移4位为00000
        * 0110
        * 0000
        * 0110
        * */
        n |= n>>>8;
        /*
         * 无符号右移8位为00000
         * 0110
         * 0000
         * 0110
         * */
        n |= n>>>16;
        /*
         * 无符号右移16位为00000
         * 0110
         * 0000
         * 0110
         * */
        System.out.println((n>>>1)+1);
        /*
        * 无符号右移1位为0011加一为 0100
        * 最终结果为4
        * */
    }

}
