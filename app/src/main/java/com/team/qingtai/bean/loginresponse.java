package com.team.qingtai.bean;

/**
 * Created by ymh on 2016/5/19.
 */
public class loginresponse {

    /**
     * version : v1.0
     * msg : ok
     * code : 0
     * first_login : 0
     */

    private String version;
    private String msg;
    private int code;
    private int first_login;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setFirst_login(int first_login) {
        this.first_login = first_login;
    }

    public String getVersion() {
        return version;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public int getFirst_login() {
        return first_login;
    }
}
