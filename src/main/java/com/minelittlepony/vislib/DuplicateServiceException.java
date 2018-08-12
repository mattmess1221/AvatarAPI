package com.minelittlepony.vislib;

public class DuplicateServiceException extends RuntimeException {

    public DuplicateServiceException(String service) {
        super(service);
    }
}
