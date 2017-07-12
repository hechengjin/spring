package common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hechengjin on 17-7-12.
 */

@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler{

    @ExceptionHandler
    public ErrorMessage defaultErrorHandler(Exception ex, HttpServletResponse response)  {
        return ErrorCode.UNKNOWN_ERROR.setMsg(ex.getMessage());
    }

    //除0异常
    @ExceptionHandler(value = {ArithmeticException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage runtimeExceptionHandler(HttpServletRequest request, ArithmeticException ex) throws Exception  {
        return ErrorCode.ARITHMETIC_EXCEPTION.setMsg(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage runtimeExceptionHandler(RuntimeException ex) {
        return ErrorCode.RUNTIME_EXCEPTION.setMsg(ex.getMessage());
    }
}
