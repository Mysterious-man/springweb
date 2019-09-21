package com.acghome.service;

import com.acghome.entity.db1.Store;
import com.acghome.query.StoreManageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<T,E> {
	List<T> getDataList(@Param("offset")int offset, @Param("limit")int limit, @Param("query") E query);

	int loadCountByQuery(@Param("query")E query);

}
