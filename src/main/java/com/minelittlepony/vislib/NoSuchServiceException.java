package com.minelittlepony.vislib;

public class NoSuchServiceException extends RuntimeException {

    public NoSuchServiceException(String serviceName) {
        super(serviceName);
    }
}
