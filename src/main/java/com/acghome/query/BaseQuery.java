package com.acghome.query;

import com.acghome.controller.ProductController;
import com.acghome.utils.exception.RequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseQuery {

	private final static Logger logger = LoggerFactory.getLogger(BaseQuery.class);



	public static int getOffset(int pageNo, int pageSize) throws RequestException {



		if (pageNo <= 0 || pageSize <= 0) {
			throw new RequestException("pageNo或pageSize参数异常");
		}

		int offset = pageSize * (pageNo - 1);

		return offset;


	}


}
