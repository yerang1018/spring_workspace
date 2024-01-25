package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.mcdonald.McdonaldDTO;


@Repository
public interface McdonaldDAO {

	
	@Select("select * from mcdonald")
	List<McdonaldDTO> selectList();

	
	@Select("select * from mcdonald where category=#{category}")
	List<McdonaldDTO> selectCategoryList(String category);

	
	
	
	@Insert("insert into mcdonald(category, name, price, memo, imgName)"
			+ " values(#{category}, #{name}, #{price}, #{memo}, #{imgName})")
	int addMenu(McdonaldDTO dto);

	
	@Delete("delete from mcdonald where idx=#{idx}")
	int DeleteIdx(int idx);

	
	@Select("select * from mcdonald where idx=#{idx}")
	McdonaldDTO SelectOne(int idx);

	
	@Update("update mcdonald set category=#{category}, name=#{name},"
			+ " price=#{price}, memo=#{memo}, imgName=#{imgName}")
	McdonaldDTO modifyIdx(int idx);



	

}
