package com.acghome.query;

import com.acghome.controller.ProductController;
import com.acghome.utils.exception.RequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseQuery {

	private final static Logger logger = LoggerFactory.getLogger(BaseQuery.class);

	private int offset;
	private int limit;
	private int pageMaxNo;


	public BaseQuery(int pageNo, int pageSize, int total) throws RequestException {



		if (pageNo <= 0 || pageSize <= 0 || total <= 0) {
			throw new RequestException("pageNo或pageSize参数异常");
		}
		if (total % pageSize == 0) {
			pageMaxNo = total / pageSize;

		} else {
			pageMaxNo = total / pageSize + 1;
		}
		if (pageNo > pageMaxNo) {
			throw new RequestException("pageNo超过可查询范围");
		}
		if (pageSize * pageNo <= total) {
			offset = pageSize * (pageNo - 1);
			limit = pageSize * pageNo;
		} else {
			offset = pageSize * (pageMaxNo - 1);
			limit = total;
		}


	}


	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public int getPageMaxNo() {
		return pageMaxNo;
	}
}
