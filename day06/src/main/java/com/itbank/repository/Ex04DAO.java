package com.itbank.repository;

import org.apache.ibatis.annotations.Insert;

import com.itbank.model.Upload2DTO;

public interface Ex04DAO {

	@Insert("insert into upload2(memo, originalFileName, storedFileName) "
			+ "	values(#{memo} , #{originalFileName}, #{storedFileName})")
	int insertMultiple(Upload2DTO dto);

}
