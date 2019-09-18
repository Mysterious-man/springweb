package com.acghome.query;

import com.acghome.utils.exception.RequestException;

import java.util.HashMap;
import java.util.Map;

public class BaseQuery {

	private int offset;
	private int limit;
	private int pageMaxNo;


	public BaseQuery(int pageNo, int pageSize, int total) throws RequestException {

		if (pageNo <= 0 || pageSize <= 0 || total <= 0) {
			throw new RequestException();
		}
		if (total % pageSize == 0) {
			pageMaxNo = total / pageSize;

		} else {
			pageMaxNo = total / pageSize + 1;
		}
		if (pageNo > pageMaxNo) {
			throw new RequestException();
		}
		if (pageSize * pageNo <= total) {
			offset = pageSize * (pageNo - 1);
			limit = pageSize * pageNo - 1;
		} else {
			offset = pageSize * (pageMaxNo - 1);
			limit = total - 1;
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
