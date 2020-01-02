package com.weimin.service.impl;

import com.weimin.common.base.BaseServiceImpl;
import com.weimin.common.base.IBaseDao;
import com.weimin.entity.Student;
import com.weimin.mapper.StudentMapper;
import com.weimin.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weimin
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @date 2020/1/2 15:46
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IBaseDao<Student> getBaseDao() {
        return studentMapper;
    }
}
