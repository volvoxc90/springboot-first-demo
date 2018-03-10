package cn.example.dao.impl;

import cn.example.domain.User;
import cn.example.dao.UserDao;
import cn.example.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-09 15:53
 **/
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserById(Integer id) {
        List<User> list = jdbcTemplate.query("select * from tb_user where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return  list.get(0);
    }

    public ServiceResult<List<User>> getUserList() {
        List<User> list = jdbcTemplate.query("select * from tb_user ", new Object[]{}, new BeanPropertyRowMapper<>(User.class));
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return new ServiceResult<List<User>>("success", list);
    }

    public int add(User user) {
        return jdbcTemplate.update("insert into tb_user(username, age, ctm) VALUES (?, ?, ?)", user.getUsername(), user.getAge(), new Date());
    }

    public int update(Integer id, User user) {
        return jdbcTemplate.update("update tb_user set username = ?, age = ? where id = ?", user.getUsername(), user.getAge(), user.getId());
    }

    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE from tb_user where id = ?", id);
    }
}