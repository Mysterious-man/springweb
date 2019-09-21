package com.acghome.service.impl;

import com.acghome.mapper.db1.BaseMapper;
import com.acghome.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
public class BaseServiceImpl<T,E> implements BaseService<T,E> {

    @Autowired
    private BaseMapper<T,E> baseMapper;


    @Override
    public List<T> getDataList(int offset, int limit, E query) {
        return baseMapper.getDataList(offset,limit,query);
    }

    @Override
    public int loadCountByQuery(E query) {
        return baseMapper.loadCountByQuery(query);
    }
}
