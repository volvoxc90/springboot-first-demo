package cn.example.service;

import cn.example.domain.User;
import cn.example.mapper.UserMapper;
import cn.example.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-09 16:49
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    // ****************************************************************** jdbcTemplace ******************************************************************
    /*@Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public ServiceResult<List<User>> getUserList() {
        ServiceResult<List<User>> result = userDao.getUserList();
        return new ServiceResult<>("SUCCESS", result.getResult());
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userDao.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }*/

//    ****************************************************************** Mybatis ******************************************************************


    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public ServiceResult<List<User>> getUserList() {
        List<User> list = userMapper.getUserList();
        ServiceResult result = new ServiceResult();
        result.setResult(list);
        return new ServiceResult("SUCCESS", result.getResult());
    }

    @Override
    public int add(User user) {
        if (user == null) {
            return 0;
        }
        return userMapper.add(user);
    }

    @Override
    public int update(Integer id, User user) {
        if (id == null || user.getUsername() == null || user.getAge() < 0) {
            return 0;
        }
        return userMapper.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        if (id == null) {
            return 0;
        }
        return userMapper.delete(id);
    }
}