package com.weimin.common.vo;

import lombok.Data;

/**
 * @author weimin
 * @ClassName ResultBean
 * @Description TODO
 * @date 2020/1/2 17:09
 */
@Data
public class ResultBean<T> {
    private Integer status;
    private T data;
}
