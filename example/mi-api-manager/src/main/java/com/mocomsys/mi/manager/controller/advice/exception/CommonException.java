package com.mocomsys.mi.manager.controller.advice.exception;

public class CommonException extends RuntimeException {
    public CommonException(String msg, Throwable t) {
        super(msg, t);
    }
    public CommonException(String msg) {
        super(msg);
    }
    public CommonException() {
        super();
    }
}