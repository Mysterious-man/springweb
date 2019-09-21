package com.acghome.mapper.db1;


import com.acghome.entity.db1.Store;
import com.acghome.query.StoreManageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T,E> {
	int loadCountByQuery(@Param("query") E query);

	List<T> getDataList(@Param("offset")int offset, @Param("limit")int limit, @Param("query") E query);

}
