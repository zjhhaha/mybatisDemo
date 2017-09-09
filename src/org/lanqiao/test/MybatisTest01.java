package org.lanqiao.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.bean.User;
import org.lanqiao.mapper.IUserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ccc on 2017/8/29.
 */
public class MybatisTest01 {
    public static void main(String[] args) {
        // getAllUser();
        //getUserById(1);
       // delUserById(2);
        User user=new User(6,"sw","12");
        addUser(user);
       // User user=new User(1,"ss","000");
      //updateUserById(user);
    }

    public static void getAllUser() {
        //配置文件的路径
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建会话工厂---sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 根据会话工厂，创建session用来执行sql操作的
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            List<User> user = userMapper.getALLUser();
            for (User us : user) {
                System.out.println(us);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getUserById(int id) {
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
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            User user = sqlSession.selectOne("org.lanqiao.mapper.userMapper.getUserById", id);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delUserById(int id) {
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
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            //执行sql语句
            sqlSession.delete("org.lanqiao.mapper.userMapper.delUserById", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(User user) {
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
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            //执行sql语句
            sqlSession.insert("org.lanqiao.mapper.userMapper.addUser", user);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserById(User user){
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
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        //执行sql语句
        sqlSession.update("org.lanqiao.mapper.userMapper.updateUserById",user);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
