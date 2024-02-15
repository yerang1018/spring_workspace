package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.SalesDTO;

public interface SalesDAO {

	@Select("select p.name as s_name, s.* from sales1 s join product1 p on p.idx = s.s_product_idx")
	List<SalesDTO> selectList();

}
