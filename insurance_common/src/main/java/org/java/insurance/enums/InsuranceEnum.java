package org.java.insurance.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 封装异常信息的枚举类
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum InsuranceEnum {
    //此处，相当于带参数的构造方法
    PRICE_CANNOT_BE_NOT(400,"价格不允许为空");

    private int code;//状态码
    private String msg;//异常原因
}
