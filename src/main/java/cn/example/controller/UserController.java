package cn.example.controller;

import cn.example.domain.User;
import cn.example.service.UserService;
import cn.example.utils.ServiceResult;
import cn.example.utils.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhugp
 * @create 2018-03-09 16:58
 * Restful 模式
 **/
@Api(value = "UserController相关的API")
@RestController
public class UserController {

    static Map<Integer, User> currentHashMap = new ConcurrentHashMap<>();

    @Autowired
    private UserService userService;

    // ********JdbcTemplace*************

    /**
     * 测试接口
     * http://localhost:8080/user/2
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取用户信息",  notes = "根据id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
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
     *
     * CrossOrigin
     *
     * @return
     *
     */
    @CrossOrigin
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
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
    @ApiOperation(value = "添加用户", notes = "根据user对象添加用户")
    @ApiImplicitParam(name = "user", value = "用户实体对象", required = true, dataType = "User")
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
    @ApiOperation(value = "修改用户", notes = "根据id修改指定用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体对象", required = true, dataType = "User")
    })
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
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据用户ID删除")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public WebResult delete(@PathVariable("id") Integer id) {
        try {
            User user = userService.getUserById(id);
            if(user == null) {
                return new WebResult("NON", "用户不存在，请重新输入id");
            }
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
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "user2/{id}", method = RequestMethod.GET)
    public WebResult getUserById2(@PathVariable("id") Integer id) {
        try {
            User user = userService.getUserById(id);
            return new WebResult("SUCCESS", user);
        } catch (Exception e) {
            return new WebResult("FAILE", e.getClass().getName());
        }
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "users2", method = RequestMethod.GET)
    public WebResult getUserList2() {
        try {
            ServiceResult result = userService.getUserList();
            return new WebResult(result.getCode(), result.getResult());
        } catch (Exception e) {
            return new WebResult("ERROR", e.getClass().getName());
        }
    }

    @ApiOperation(value = "添加用户", notes = "根据实体对象user添加用户")
    @ApiImplicitParam(name = "user", value = "实体对象", required = true, dataType = "User")
    @RequestMapping(value = "user2", method = RequestMethod.POST)
    public WebResult add2(@RequestBody User user) {
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

    @ApiOperation(value = "修改用户", notes = "根据用户ID修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户实体对象", required = true, dataType = "User")
            })
    @RequestMapping(value = "user2/{id}", method = RequestMethod.PUT)
    public WebResult update2(@PathVariable("id") Integer id, @RequestBody User user) {
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

    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Integer")
    @RequestMapping(value = "user2/{id}", method = RequestMethod.DELETE)
    public WebResult delete2(@PathVariable("id") Integer id) {
        try {
            User user = userService.getUserById(id);
            if (user == null) {
                return new WebResult("NON", "用户不存在，请重新输入id");
            }
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
}