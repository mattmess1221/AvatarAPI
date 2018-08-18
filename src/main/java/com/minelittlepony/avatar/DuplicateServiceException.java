package com.minelittlepony.avatar;

public class DuplicateServiceException extends RuntimeException {

    public DuplicateServiceException(String service) {
        super(service);
    }
}
