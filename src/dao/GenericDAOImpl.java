package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public abstract class GenericDAOImpl<T,PK extends Serializable> implements GenericDAO<T, PK>
{
	private Class<T> classtype;
	protected String ClassName;

    @SuppressWarnings("unchecked")
	public GenericDAOImpl()
    {
		Type t = getClass().getGenericSuperclass();
    	ParameterizedType pt = null;
    	if (getClass().toString().indexOf(t.toString())!=0)
    	{
    		 pt= (ParameterizedType) t;
    	     classtype = (Class<T>) pt.getActualTypeArguments()[0];
    	     
    	     String s=classtype.getName();
    	     if (s.indexOf('.')>=0)
    	    	 ClassName= s.substring(s.lastIndexOf('.')+1,s.length());
    	     else
    	    	 ClassName=s;
    	}
    }
    
    
    public T Insert(T t, EntityManager entityManager)
    {
        entityManager.persist(t);
		entityManager.flush();
        return t;
    }
    
    public T Update(T t, EntityManager entityManager)
	{
	    return entityManager.merge(t);
	}
	
	public void Delete(T t, EntityManager entityManager)
	{
	    t = entityManager.merge(t);
	    entityManager.remove(t);
	}


	public T SelectById(PK id, EntityManager entityManager)
	{
	    return entityManager.find(classtype, id);
	}
    
	@SuppressWarnings("unchecked")
	public List<T> SelectAll(EntityManager entityManager)
	{
		Query query = entityManager.createQuery("SELECT e FROM " + ClassName + " e");
	    return (List<T>) query.getResultList();
	}
	
	public int SelectCount(EntityManager entityManager)
	{
		Query query = entityManager.createQuery("SELECT COUNT(e) FROM " + ClassName + " e");
	    return Integer.parseInt(query.getSingleResult().toString());
	}

	public void Insert(List<T> ts,EntityManager entityManager)
	{
		for(T t:ts)
			this.Insert(t,entityManager);
	}


	public void Update(List<T> ts,EntityManager entityManager)
	{
		for(T t:ts)
			this.Update(t,entityManager);
	}
 

	public void Delete(List<T> ts,EntityManager entityManager)
	{
		for(T t:ts)
			this.Delete(t,entityManager);
	}
    
}
