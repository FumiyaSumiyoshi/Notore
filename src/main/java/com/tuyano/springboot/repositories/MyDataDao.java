package com.tuyano.springboot.repositories;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao <T> extends Serializable {
	
	public List<T> getAll();
	public T findById(long id); //p271追加文
	public List<T> findByName(String name); //p271追加文　名前からエンティティを検索
	public List<T> find(String fstr); //p280で追加
	public List<MyData2> findByAge(int min, int max); //p288で追加
	
	
}
