package com.boot.vue.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private Integer code = 500;
    private String message;

    public BaseException(String message) {
        this.message = message;
    }

}
