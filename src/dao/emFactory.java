package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Irani on 10/9/2015.
 */
public class emFactory
{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public emFactory()
    {
    }

    public EntityManager getEntityManager()
    {
        if (entityManager==null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("libraryPU");
            entityManager=entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }

}
