package com.wtr.dagger2;

/**
 * 作者：Tangren_ on 2017/4/28 0028.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class Person {
    private String name;
    private String msg;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
