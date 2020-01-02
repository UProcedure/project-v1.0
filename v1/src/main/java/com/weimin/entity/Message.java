package com.weimin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author weimin
 * @ClassName Message
 * @Description TODO
 * @date 2020/1/2 15:27
 */
@Data
public class Message<T> implements Serializable {
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;

    private Integer typeId;
    private T data;
}
