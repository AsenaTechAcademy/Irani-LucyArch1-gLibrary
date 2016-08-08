package dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,PK extends Serializable>
{
	public T Insert(T t, EntityManager entityManager);
	public void Insert(List<T> ts, EntityManager entityManager);
	public T Update(T t, EntityManager entityManager);
	public void Update(List<T> ts, EntityManager entityManager);
	public void Delete(T t, EntityManager entityManager);
	public void Delete(List<T> ts, EntityManager entityManager);
	
	public List<T> SelectAll(EntityManager entityManager);
	public T SelectById(PK Id,EntityManager entityManager);
	public int SelectCount(EntityManager entityManager);
}
