package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
