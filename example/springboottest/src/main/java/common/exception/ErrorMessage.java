package common.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by hechengjin on 17-7-12.
 */
public class ErrorMessage {

    private Integer code;
    private String msg;

    public static ErrorMessage create() {
        return new ErrorMessage();
    }

    public Integer getCode() {
        return code;
    }

    public ErrorMessage setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorMessage setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
