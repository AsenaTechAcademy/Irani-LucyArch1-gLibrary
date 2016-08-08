package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Irani on 10/9/2015.
 */
public class emFactory
{
    private static final EntityManagerFactory emf;
    private static final ThreadLocal entityManager=new ThreadLocal();

    static
    {
        try
        {
            emf=Persistence.createEntityManagerFactory("libraryPU");
        }
        catch (Throwable ex)
        {
            System.err.println("Can not create Entity Manager Factory in emFactory." + ex);
            //Logger.Log(ex);
            throw new ExceptionInInitializerError(ex);
        }

    }


    //Singleton Pattern
    public static EntityManager getEntityManager()
    {
        EntityManager emm=(EntityManager) entityManager.get();
        if (emm==null)
        {
            emm=emf.createEntityManager();
            entityManager.set(emm);
        }
        return emm;
    }


    public static void CloseEntityManager()
    {
        EntityManager emm=(EntityManager)entityManager.get();
        if (emm != null)
            emm.close();
        entityManager.set(null);
    }

}
