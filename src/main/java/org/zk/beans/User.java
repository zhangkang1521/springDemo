package org.zk.beans;

import java.util.List;

/**
 * Created by zhangkang on 2016/4/27.
 */
public class User {
    private Integer id;
    private String userName;
    private Integer age;
    List<String> list;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
