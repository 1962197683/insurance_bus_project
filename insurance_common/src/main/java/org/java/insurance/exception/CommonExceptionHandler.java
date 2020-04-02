package org.java.insurance.exception;

import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.ov.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 该方法，处理服务中 ，产生的运行时异常
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleException(InsuranceException ex){
       //这种方式，不太灵活的地方，它将异常的状态码写成400,但产生异常的状态码，也有可能是其他状态
        //所以，此处，不可以将状态码固定写成某一个值
        //正确的处理方法，应该是：将异常的状态码，与异常的原因，封装成一个枚举类型ENUM类型
        
        //获得ShoppingException中的枚举属性
        InsuranceEnum shoppingEnum = ex.getShoppingEnum();

        //构建一个ExceptionResult对象，返回异常信息
        return ResponseEntity.status(shoppingEnum.getCode()).body(new ExceptionResult(shoppingEnum));
    }
}
