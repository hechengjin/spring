package common.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by hechengjin on 17-7-12.
 */
public class ErrorCode {
    private static ErrorMessage registerErrorMsg(Integer code, String msg) {
        return ErrorMessage.create()
                .setCode(code)
                .setMsg(msg);
    }

    //success code
    public static final ErrorMessage SUCCESS =
            registerErrorMsg(0, "SUCCESS");

    // exception code

    public static final ErrorMessage UNKNOWN_ERROR =
            registerErrorMsg(100001, "Unknown error");

    public static final ErrorMessage ARITHMETIC_EXCEPTION =
            registerErrorMsg(100002, "Arithmetic Exception zeroException...");

    public static final ErrorMessage RUNTIME_EXCEPTION =
            registerErrorMsg(100003, "Runtime Exception");

}
