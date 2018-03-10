package cn.example.mapper;

import cn.example.domain.User;
import cn.example.utils.ServiceResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-10 16:13
 **/
@Component
public interface UserMapper {
    public User getUserById(Integer id);

    public ServiceResult<List<User>> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);

}
