package cn.example.mapper;

import cn.example.domain.User;
import cn.example.utils.ServiceResult;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======
import org.apache.ibatis.annotations.Mapper;
>>>>>>> 2f204bc6b43679711b60c7144b8edf525fd706f9
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-10 16:13
 **/
@Mapper
public interface UserMapper {
    public User getUserById(Integer id);

    public ServiceResult<List<User>> getUserList();

    public int add(User user);

    public int update(@Param("id")Integer id, @Param("user") User user);

    public int delete(Integer id);

}
