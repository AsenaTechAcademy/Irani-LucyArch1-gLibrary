package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,PK extends Serializable>
{
	public T Insert(T t);
	public void Insert(List<T> ts);
	public T Update(T t);
	public void Update(List<T> ts);
	public void Delete(T t);
	public void Delete(List<T> ts);
	
	public List<T> SelectAll();
	public T SelectById(PK Id);
	public int SelectCount();
}
