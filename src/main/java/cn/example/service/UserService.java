package cn.example.service;

import cn.example.domain.User;
import cn.example.utils.ServiceResult;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-09 16:29
 **/
public interface UserService {

    public User getUserById(Integer id);

    public ServiceResult<List<User>> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);
}