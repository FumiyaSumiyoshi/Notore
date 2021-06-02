package com.tuyano.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyDataRepository2 extends JpaRepository<MyData2, Long> {
	
	public MyData2 findByid(Long name);
	public List<MyData2> findByNameLike(String name);
	public List<MyData2> findByIdIsNotNullOrderByIdDesc();
	public List<MyData2> findByAgeGreaterThan(Integer age);
	public List<MyData2> findByAgeBetween(Integer age1, Integer age2);
	
}
