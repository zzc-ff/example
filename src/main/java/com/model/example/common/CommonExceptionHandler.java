package com.model.example.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**统一异常处理类
 *
 * @RestControllerAdvice
 * 返会json
 * @ControllerAdvice
 * 返回视图解析
 *
 */
@RestControllerAdvice
public class CommonExceptionHandler {
    Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    /**
     * 参数校验 统一异常返回
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        logger.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return Result.error(Constants.PARAM_ERROR,fieldError.getDefaultMessage());
    }


    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        FieldError fieldError = ex.getBindingResult().getFieldError();
        logger.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return Result.error(Constants.PARAM_ERROR,fieldError.getDefaultMessage());
    }
    /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        return Result.error(Constants.PROGRAM_ERROR,e.getMessage());
    }
}
