package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.ProductDTO;

public interface ProductDAO {

	
	@Select("select * from product1 order by idx desc")
	List<ProductDTO> selectList();
	

	@Insert("insert into product1(name, img, price, save_img) values(#{name}, #{img}, #{price}, #{save_img})")
	int insertFile(ProductDTO dto);

	@Update("update product1 set count = #{count} where idx = #{idx}")
	int update(ProductDTO dto);

	@Select("select * from product1 where idx = #{idx}")
	ProductDTO SelectOne(int idx);

	@Delete("delete from product1 where idx = #{idx}")
	int delete(int idx);

	

}
