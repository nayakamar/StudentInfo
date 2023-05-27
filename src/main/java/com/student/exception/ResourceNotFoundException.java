package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resorceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resorceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with : '%s'", resorceName, fieldName, fieldValue));
        this.resorceName = resorceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResorceName() {
        return resorceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
