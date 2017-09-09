package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.bean.User;

import java.util.List;

/**
 * Created by ccc on 2017/8/29.
 */
public interface IUserMapper {
    /**
     * 获取所以用户
     * @return用户集合
     */
    @Select("select * from user")
    public List<User> getALLUser();

    /**
     * 根据id查询用户
     * @param id
     * @return用户对象
     */
    @Select("select * from user where id=#{id}")
     User getUserById(int id);

    /**
     * 根据id删除用户
     * @param id
     * @return执行结果
     */
    @Delete("delete from user where id=#{id}")
     int delUserById(int id);

    /**
     * 插入某个用户
     * @param user
     * @return
     */
    @Insert("insert into user(name,pass) values(#{name},#{pass})")
     int addUser(User user);

    /**
     * 修改某个用户
     * @param user
     * @return执行结果
     */
    @Update("update user set name=#{name},pass=#{pass} where id=#{id}")
     int UpdateUser(User user);
}
