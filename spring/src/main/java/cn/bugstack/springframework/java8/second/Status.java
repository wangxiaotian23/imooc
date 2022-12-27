package cn.bugstack.springframework.java8.second;

/**
 * @Auther: 李清依
 * @Date: 2022/12/6 16:46
 * @Description:
 */
public enum Status {
    VOCATION("vocation",3),
    FREE("free",2),
    BUSY("busy",1);

    Status(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
