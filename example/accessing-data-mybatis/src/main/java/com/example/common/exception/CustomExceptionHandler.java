package com.example.common.exception;

import com.example.common.model.ErrorCode;
import com.example.common.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

/**
 * Created by hechengjin on 17-8-3.
 */
@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //处理未处理的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleExceptionHandler(Exception ex) {
        logger.error("unknown error:", ex);
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.UNKNOWN.getCode(), ErrorCode.UNKNOWN.getResult() + ex.getMessage(), ErrorCode.UNKNOWN.getHttpStatus());
        return handleResponse(errorMessage, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseEntity<Object> handleArithmeticExceptionHandler(Exception ex) {
        logger.error("ArithmeticException error:", ex);
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.ARITHMETIC_ERROR.getCode(), ErrorCode.ARITHMETIC_ERROR.getResult() + ex.getMessage(), ErrorCode.ARITHMETIC_ERROR.getHttpStatus());
        return handleResponse(errorMessage, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleDataIntegrityViolationException(Exception ex) {
        logger.error("Data Integrity Constraint Exception:", ex);
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.DATA_INTEGRITY_CONSTRAINT_EXCEPTION.getCode(), ErrorCode.DATA_INTEGRITY_CONSTRAINT_EXCEPTION.getResult() + ex.getMessage(), ErrorCode.DATA_INTEGRITY_CONSTRAINT_EXCEPTION.getHttpStatus());
        return handleResponse(errorMessage, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResponseEntity<Object> handleDuplicateKeyException(Exception ex) {
        logger.error("Duplicate Key Exception:", ex);
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.DUPLICATE_KEY_EXCEPTION.getCode(), ErrorCode.DUPLICATE_KEY_EXCEPTION.getResult() + ex.getMessage(), ErrorCode.DUPLICATE_KEY_EXCEPTION.getHttpStatus());
        return handleResponse(errorMessage, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> handleResponse(ErrorMessage errorMessage, HttpHeaders headers, HttpStatus status) {
        return new ResponseEntity<>((Object) errorMessage, headers, status);
    }

    // 处理@RequestParam错误, 即参数不足
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ErrorCode.ILLEGAL_ARGUMENT.getResult() + ex.getMessage(), ErrorCode.ILLEGAL_ARGUMENT.getHttpStatus());
        return handleResponse(errorMessage, headers, status);
    }

    //处理400错误
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        logger.error("Internal Exception:",ex);
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.INTERNAL_ERROR.getCode(), ErrorCode.INTERNAL_ERROR.getResult() + ex.getMessage(), ErrorCode.INTERNAL_ERROR.getHttpStatus());
        return handleResponse(errorMessage, headers, status);
    }

    //处理参数类型转换失败
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("TypeMismatchException:",ex);
        ErrorMessage errorMessage = new ErrorMessage(ErrorCode.ARGUMENT_TYPE_ERROR.getCode(), ErrorCode.ARGUMENT_TYPE_ERROR.getResult() + ex.getMessage(), ErrorCode.ARGUMENT_TYPE_ERROR.getHttpStatus());
        return handleResponse(errorMessage, headers, status);
    }

}
