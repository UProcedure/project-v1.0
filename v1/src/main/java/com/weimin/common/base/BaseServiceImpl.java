package com.weimin.common.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author weimin
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @date 2019/10/29 10:17
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    public abstract IBaseDao<T> getBaseDao();


    @Override
    public int deleteByPrimaryKey(Long id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return getBaseDao().insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return getBaseDao().insertSelective(t);
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return getBaseDao().updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return getBaseDao().updateByPrimaryKey(t);
    }

    @Override
    public List<T> getList(){
        return getBaseDao().getList();
    }

    @Override
    public PageInfo<T> getPageList(Integer pageIndex, Integer pageSize, Integer navigatePages){
        PageHelper.startPage(pageIndex,pageSize);
        return new PageInfo<T>(this.getList(),navigatePages);
    }
}
