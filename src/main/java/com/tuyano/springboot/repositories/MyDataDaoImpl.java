package com.tuyano.springboot.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData2> {
	
	private static final long serialVersionID = 1L;
	
	private EntityManager entityManager;
	
	public MyDataDaoImpl() {
		
		super();
		
	}
	
	public MyDataDaoImpl(EntityManager manager) {
		
		entityManager = manager;
		
	}
	
	///////↓大元///////////////////////////////////////////////////////////////////////////
//	@Override
//	public List<MyData2> getAll() {
//		
//		Query query = entityManager.createQuery("from MyData2");
//		List<MyData2> list = query.getResultList();
//		entityManager.close();
//		return list;
//		
//	}
	/////////↑大元/////////////////////////////////////////////////////////////////////////
	///////↓p292///////////////////////////////////////////////////////////////////////////
//	@Override
//	public List<MyData2> getAll() {
//		
//		List<MyData2> list = null;
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		
//		CriteriaQuery<MyData2> query = builder.createQuery(MyData2.class);
//		
//		Root<MyData2> root = query.from(MyData2.class);
//		
////		query.select(root);//大元
//		query.select(root).orderBy(builder.asc(root.get("name")));
//		
//		list = (List<MyData2>)entityManager.createQuery(query).getResultList();
//		
//		return list;
//		
//	}
	/////////↑p292/////////////////////////////////////////////////////////////////////////
	///////↓p299///////////////////////////////////////////////////////////////////////////
	@Override
	public List<MyData2> getAll() {
		
		int offset = 1;
		int limit = 2;
		
		List<MyData2> list = null;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<MyData2> query = builder.createQuery(MyData2.class);
		
		Root<MyData2> root = query.from(MyData2.class);
		
		query.select(root);//大元
		
		list = (List<MyData2>)entityManager.createQuery(query).setFirstResult(offset).setMaxResults(limit).getResultList();
		
		return list;
		
	}
	/////////↑p299/////////////////////////////////////////////////////////////////////////
	////////↓p272追加文//////////////////////////////////////////////////////////////////////////
	@Override
	public MyData2 findById(long id) {
		
		return (MyData2)entityManager.createQuery("from MyData2 where id = " + id).getSingleResult();
		
	}
	
	@Override
	public List<MyData2> findByName(String name) {
		
		return (List<MyData2>)entityManager.createQuery("from MyData2 where name = " + name).getResultList();
		
	}
	//////////↑p272追加文/////////////////////////////////////////////////////////////////
	
	////////↓p280追加文//////////////////////////////////////////////////////////////////////////
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MyData2> find(String fstr) {
//		
//		List<MyData2> list = null;
//		String qstr = "from MyData2 where id = :fstr";
//		Query query = entityManager.createQuery(qstr).setParameter("fstr", Long.parseLong(fstr));
//		list = query.getResultList();
//		return list;
//		
//	}
	//////////↑p280追加文/////////////////////////////////////////////////////////////////
////////↓p283追加文//////////////////////////////////////////////////////////////////////////
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MyData2> find(String fstr) {
//		
//		List<MyData2> list = null;
//		String qstr = "from MyData2 where id = ?1 or name like ?2 or mail like ?3";
//		Long fid = 0L;
//		try {
//			fid = Long.parseLong(fstr);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		Query query = entityManager.createQuery(qstr).setParameter(1, fid).setParameter(2, "%" + fstr + "%").setParameter(3, fstr + "@%");
//		list = query.getResultList();
//		return list;
//		
//	}
//////////↑p283追加文/////////////////////////////////////////////////////////////////
////////↓p285追加文//////////////////////////////////////////////////////////////////////////
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MyData2> find(String fstr) {
//		
//		List<MyData2> list = null;
//		Long fid = 0L;
//		try {
//			fid = Long.parseLong(fstr);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		Query query = entityManager.createNamedQuery("findWithName").setParameter("fname", "%" + fstr + "%");
//		list = query.getResultList();
//		return list;
//		
//	}
//////////↑p285追加文/////////////////////////////////////////////////////////////////
////////↓p293追加文//////////////////////////////////////////////////////////////////////////
//	@SuppressWarnings("unchecked")
	@Override
	public List<MyData2> find(String fstr) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<MyData2> query = builder.createQuery(MyData2.class);
		
		Root<MyData2> root = query.from(MyData2.class);
		
		query.select(root).where(builder.equal(root.get("name"), fstr));
		
		List<MyData2> list = null;
		list = (List<MyData2>) entityManager.createQuery(query).getResultList();
		
		return list;
		
	}
//////////↑p293追加文/////////////////////////////////////////////////////////////////
////////↓p288追加文//////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	@Override
	public List<MyData2> findByAge(int min, int max) {
		
		return (List<MyData2>)entityManager
				.createNamedQuery("findByAge")
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
		
	}
//////////↑p288追加文/////////////////////////////////////////////////////////////////
}
