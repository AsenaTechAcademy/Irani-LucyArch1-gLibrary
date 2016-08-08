package service;

import java.util.List;


public interface npGenericService <T>
{
	public T Add(T t) throws Exception;
	public void Remove(T t);
	public T Edit(T t);
	
	public List<T> GetAll();	
} 
