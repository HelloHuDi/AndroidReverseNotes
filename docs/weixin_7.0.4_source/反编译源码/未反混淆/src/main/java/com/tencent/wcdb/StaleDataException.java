package com.tencent.wcdb;

public class StaleDataException extends RuntimeException {
    public StaleDataException(String str) {
        super(str);
    }
}
