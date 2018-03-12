package cn.example.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhugp
 * @create 2018-03-09 15:16
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", ctm=" + ctm +
                '}';
    }

    private int id;
    private String username;
    private int age;
    private Date ctm;
}