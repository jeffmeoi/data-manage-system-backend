package com.jeff.datamanagesystem;

import com.jeff.datamanagesystem.dto.ErrorCode;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;
import java.sql.SQLIntegrityConstraintViolationException;

//@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private Logger logger;

    @ExceptionHandler
    @ResponseBody
    public ErrorCode handleLoginException(LoginException e){
        logger.error("LoginException");
        return ErrorCode.FAILED;
    }


}
