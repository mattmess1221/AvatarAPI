package com.minelittlepony.vislib;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ServiceManager {

    private static Map<Class<?>, Object> services = new LinkedHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> get(Class<T> tClass) {
        return Optional.ofNullable((T) services.get(tClass));
    }

    public static <T> T getUnsafe(Class<T> tClass) throws NoSuchServiceException {
        return get(tClass).orElseThrow(() -> new NoSuchServiceException(tClass.getCanonicalName()));
    }

    public static <T> T register(Class<? super T> tClass, T service) throws DuplicateServiceException {
        if (services.containsKey(tClass)) {
            throw new DuplicateServiceException(tClass.getCanonicalName());
        }
        services.put(tClass, service);

        return service;
    }

}
