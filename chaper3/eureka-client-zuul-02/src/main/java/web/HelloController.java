package web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-04-04 14:40
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello, " + name +"," + port;
    }
}