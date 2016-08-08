package service;

import dao.emFactory;

public class ServiceManager 
{
	public static void CleanEntityManagers()
	{
		emFactory.CloseEntityManager();
	}
	
}
