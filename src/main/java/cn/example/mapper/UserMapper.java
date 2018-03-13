package cn.example.mapper;

import cn.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-10 16:13
 **/
@Mapper
public interface UserMapper {
    public User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(@Param("id")Integer id, @Param("user") User user);

    public int delete(Integer id);

}
