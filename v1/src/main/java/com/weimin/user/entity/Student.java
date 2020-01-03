package com.weimin.user.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Student implements Serializable {
    private Long id;

    private String studentId;

    private String name;

    private String sex;

    private String college;

    private String major;

    private Long classesId;

    private String classes;

    private Byte grader;

    private String phone;

    private String email;

    private Date birthday;

    private String cardId;

    private String images;

    /**
    * -1代表退学，0代表休学，1代表在读，2代表毕业
    */
    private Byte status;

    private Date admissionTime;

    private Date graduationTime;

    private static final long serialVersionUID = 1L;
}