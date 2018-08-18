package com.minelittlepony.avatar;

public class NoSuchServiceException extends RuntimeException {

    public NoSuchServiceException(String serviceName) {
        super(serviceName);
    }
}
