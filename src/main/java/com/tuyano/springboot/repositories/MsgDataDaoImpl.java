package com.tuyano.springboot.repositories;

import java.util.List;

import javax.persistence.EntityManager;

//import com.tuyano.springboot.repositories.MyData2;
//import com.tuyano.springboot.repositories.MyDataDao;

public class MsgDataDaoImpl implements MsgDataDao<MsgDataDao> {
	
	private EntityManager entityManager;
	
	public MsgDataDaoImpl() {
		super();
	}
	
	public MsgDataDaoImpl(EntityManager manager) {
		entityManager = manager;
	}

	@Override
	public List<MsgData> getAll() {
		return entityManager.createQuery("from MsgData").getResultList();
	}

	@Override
	public MsgData findById(long id) {
		return (MsgData)entityManager.createQuery("from MsgData where id = " + id).getSingleResult();
	}

}
