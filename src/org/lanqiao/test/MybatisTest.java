package org.lanqiao.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.bean.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ccc on 2017/8/28.
 */
public class MybatisTest {
    public static void main(String[] args){
        //getAllUser();
         getUserById(1);
        // User user=new User("lizq","123");
        //  addUser(user);
        //    delUserById(21);
        //User user=new User();
        //updateUserById(user);
    }

    //查询所有的用户
    public static void getAllUser(){
        //配置文件的路径
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据配置文件创建会话工厂---sqlSessionFactory
        // 根据会话工厂，创建session用来执行sql操作的
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行sql语句
        List<User> userList=sqlSession.selectList("org.lanqiao.mapper.userMapper.getAllUser");
        for (User user:userList) {
            System.out.println(user);
        }

    }

    //根据id获取单个user
    public static  void getUserById(int id){
        //配置文件的路径
        String resource = "mybatis.xml";
        //使用io流读取配置文件
        InputStream inputStream = null;
        try {
            //使用io流读取配置文件
            inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建会话工厂---sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //根据会话工厂，创建session用来执行sql操作的
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //执行sql语句
            User user= sqlSession.selectOne("org.lanqiao.mapper.userMapper.getUserById",id);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //插入一个user
    public static  void addUser(User user){
        //配置文件的路径
        String resource = "mybatis.xml";
        //使用io流读取配置文件
        InputStream inputStream = null;
        try {
            //使用io流读取配置文件
            inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建会话工厂---sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //根据会话工厂，创建session用来执行sql操作的
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //执行sql语句
            sqlSession.insert("org.lanqiao.mapper.userMapper.addUser",user);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据id获取单个user
    public static  void delUserById(int id){
        //配置文件的路径
        String resource = "mybatis.xml";
        //使用io流读取配置文件
        InputStream inputStream = null;
        try {
            //使用io流读取配置文件
            inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建会话工厂---sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //根据会话工厂，创建session用来执行sql操作的   openSession如果传入一个true 表示事务自动提交
            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            //执行sql语句
            sqlSession.delete("org.lanqiao.mapper.userMapper.delUserById",id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //更新一个user
    public static  void updateUserById(User user){
        //配置文件的路径
        String resource = "mybatis.xml";
        //使用io流读取配置文件
        InputStream inputStream = null;
        try {
            //使用io流读取配置文件
            inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建会话工厂---sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //根据会话工厂，创建session用来执行sql操作的
            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            //执行sql语句
            sqlSession.update("org.lanqiao.mapper.userMapper.updateUserById",user);
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
