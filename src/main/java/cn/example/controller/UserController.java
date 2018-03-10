package cn.example.controller;

import cn.example.domain.User;
import cn.example.service.UserService;
import cn.example.utils.ServiceResult;
import cn.example.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhugp
 * @create 2018-03-09 16:58
 * Restful 模式
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // ********JdbcTemplace*************

    /**
     * 测试接口
     * http://localhost:8080/user/2
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public WebResult getUserById(@PathVariable("id") Integer id) {
        try {
            User user = userService.getUserById(id);
            return new WebResult("SUCCESS", user);
        } catch (Exception e) {
            return new WebResult("ERROR", e.getClass().getName());
        }
    }

    /**
     * 测试接口
     * http://localhost:8080/users
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public WebResult getUserList() {
        try {
            ServiceResult result = userService.getUserList();
            return new WebResult(result.getCode(), result.getResult());
        } catch (Exception e) {
            return new WebResult("ERROR", e);
        }
    }

    /**
     * 测试接口
     * http://localhost:8080/user
     * {"username":"张馨","age":29}
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public WebResult add(@RequestBody User user) {
        WebResult result = new WebResult();
        try {
            int num = userService.add(user);
            if (num > 0) {
                return new WebResult("SUCCESS", "添加成功");
            } else {
                return new WebResult("FAILE", "添加失败");
            }
        } catch (Exception e) {
            return new WebResult("ERROR", e.getClass().getName());
        }
    }

    /**
     * 测试接口
     * http://localhost:8080/user/1
     * {"username":"张馨","age":27}
     *
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public WebResult update(@PathVariable("id") Integer id, @RequestBody User user) {
        try {
            int num = userService.update(id, user);
            if (num > 0) {
                return new WebResult("SUCCESS", "修改成功");
            } else {
                return new WebResult("FAILE", "修改失败");
            }
        } catch (Exception e) {
            return new WebResult("ERROR", e.getClass().getName());
        }
    }

    /**
     * 测试接口
     * http://localhost:8080/user/1
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public WebResult delete(@PathVariable("id") Integer id) {
        try {
            int num = userService.delete(id);
            if (num > 0) {
                return new WebResult("SUCCESS", "删除成功");
            } else {
                return new WebResult("FAILE", "删除失败");
            }
        } catch (Exception e) {
            return new WebResult("ERROR", e.getClass().getName());
        }
    }


    // ****************************************************************** Mybatis ******************************************************************

    /**
     * 测试接口
     * http://localhost:8080/user2/2
     * @param id
     * @return
     */
    @RequestMapping(value = "user2/{id}", method = RequestMethod.GET)
    public WebResult getUserById2(@PathVariable("id")Integer id) {
        try {
            User user = userService.getUserById(id);
            return new WebResult("SUCCESS", user);
        } catch (Exception e) {
            return new WebResult("FAILE", e.getClass().getName());
        }
    }
}