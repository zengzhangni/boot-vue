package com.boot.vue.utils.exception;

import com.boot.vue.utils.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 全局统一拦截exception异常
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {


    /**
     * 全局统一拦截exception异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseMessage exceptionHandler(Exception ex) {
        log.error("异常!:errmsg:{}", ex.getStackTrace()[0]);
        ex.printStackTrace();
        return new ResponseMessage<>(500, StringUtils.isBlank(ex.getMessage()) ? "未知异常!" : ex.getMessage());
    }


    /**
     * 空指针异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseMessage nullPointerException(NullPointerException ex) {
        log.error("空指针异常!:errmsg:{}", ex.getStackTrace()[0]);
        return new ResponseMessage<>(500, StringUtils.isBlank(ex.getMessage()) ? "空指针异常!" : ex.getMessage(), ex.getStackTrace()[0]);
    }

    /**
     * 服务异常处理
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseMessage baseException(BaseException ex) {
        return new ResponseMessage<>(ex.getCode(), ex.getMessage());
    }

    /**
     * 统一处理 BindException 错误
     *
     * @param ex 参数验证失败错误
     * @return 参数验证失败响应
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseMessage methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // 获取错误信息
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        // 目前消息只返回一条错误信息，所以只需要取第一条错误信息即可
        Map<String, String> errorMap = null;
        if (fieldErrors.size() > 0) {
            errorMap = new HashMap<>(fieldErrors.size());
            for (FieldError fieldError : fieldErrors) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        // 请求路径
        return new ResponseMessage<>(500, "参数校验异常", errorMap);
    }


}

