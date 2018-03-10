package cn.example.domain;


import lombok.Data;

import java.util.Date;

/**
 * @author zhugp
 * @create 2018-03-09 15:16
 **/
@Data
public class User {

    private int id;
    private String username;
    private int age;
    private Date ctm;
}