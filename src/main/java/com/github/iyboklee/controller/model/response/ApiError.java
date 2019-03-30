/**
 * @Author iyboklee (iyboklee@gmail.com)
 */
package com.github.iyboklee.controller.model.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiError {

    private String message;
    private int status;

    public ApiError(Throwable throwable, HttpStatus status) {
        this(throwable.getMessage(), status);
    }

    public ApiError(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }

}