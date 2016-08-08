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
    
    
    public T Insert(T t)
    {
        emFactory.getEntityManager().persist(t);
        emFactory.getEntityManager().flush();
        return t;
    }
    
    public T Update(T t)
	{
	    return emFactory.getEntityManager().merge(t);
	}
	
	public void Delete(T t)
	{
	    t = emFactory.getEntityManager().merge(t);
	    emFactory.getEntityManager().remove(t);
	}


	public T SelectById(PK id)
	{
	    return emFactory.getEntityManager().find(classtype, id);
	}
    
	@SuppressWarnings("unchecked")
	public List<T> SelectAll()
	{
		Query query = emFactory.getEntityManager().createQuery("SELECT e FROM " + ClassName + " e");
	    return (List<T>) query.getResultList();
	}
	
	public int SelectCount()
	{
		Query query = emFactory.getEntityManager().createQuery("SELECT COUNT(e) FROM " + ClassName + " e");
	    return Integer.parseInt(query.getSingleResult().toString());
	}

	public void Insert(List<T> ts)
	{
		for(T t:ts)
			this.Insert(t);
	}


	public void Update(List<T> ts)
	{
		for(T t:ts)
			this.Update(t);
	}
 

	public void Delete(List<T> ts)
	{
		for(T t:ts)
			this.Delete(t);
	}
    
}
