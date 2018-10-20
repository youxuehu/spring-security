package com.gq.security.core.validate;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Administrator on 2018/10/20.
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
