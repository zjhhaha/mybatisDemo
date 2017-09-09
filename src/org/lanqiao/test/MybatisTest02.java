package org.lanqiao.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.bean.Action;
import org.lanqiao.bean.User;
import org.lanqiao.mapper.IUserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ccc on 2017/8/29.
 */
public class MybatisTest02 {
    public static void main(String[] args) {
        getAllAction();
    }

    public static void getAllAction() {
        //配置文件的路径
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建会话工厂---sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 根据会话工厂，创建session用来执行sql操作的
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            List<Action> actions=sqlSession.selectList("org.lanqiao.mapper.actionMapper.getAllAction");
            for (Action action:actions){
                System.out.println(action);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
