package com.example.common.model;

import org.apache.http.HttpStatus;

/**
 * Created by hechengjin on 17-8-2.
 */
public final class ErrorCode {

    private static ErrorMessage addErrorMsg(Integer code, String result, Integer httpStatus) {
        return ErrorMessage.create(code, result, httpStatus);
    }

    //success
    public static final ErrorMessage SUCCESS = addErrorMsg(0, "SUCCESS. ", HttpStatus.SC_OK);

    //unknown
    public static final ErrorMessage UNKNOWN = addErrorMsg(900000, "Unknown error. ", HttpStatus.SC_INTERNAL_SERVER_ERROR);

    //illegal argument
    public static final ErrorMessage ILLEGAL_ARGUMENT = addErrorMsg(900001, "Illegal Argument. ", HttpStatus.SC_BAD_REQUEST);

    //db error
    public static final ErrorMessage DB_ERROR = addErrorMsg(900002, "DB Error. ", HttpStatus.SC_BAD_REQUEST);

    //argument type error
    public static final ErrorMessage ARGUMENT_TYPE_ERROR = addErrorMsg(900003, "argument type error. ", HttpStatus.SC_BAD_REQUEST);

    //Internal error
    public static final ErrorMessage INTERNAL_ERROR = addErrorMsg(900004, "Bad Request internal error. ", HttpStatus.SC_BAD_REQUEST);

    //Arithmetic error
    public static final ErrorMessage ARITHMETIC_ERROR = addErrorMsg(900005, "arithmetic error. ", HttpStatus.SC_BAD_REQUEST);

    //Integrity 完整性 Constraint 约束 Violation 违反 Exception
    public static final ErrorMessage DATA_INTEGRITY_CONSTRAINT_EXCEPTION = addErrorMsg(900006, "数据完整性约束异常. ", HttpStatus.SC_BAD_REQUEST);

    //唯一键重复
    public static final ErrorMessage DUPLICATE_KEY_EXCEPTION = addErrorMsg(900007, "唯一键重复. ", HttpStatus.SC_BAD_REQUEST);

}
