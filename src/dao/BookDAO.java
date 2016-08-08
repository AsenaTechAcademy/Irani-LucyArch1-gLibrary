package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import common.model.Book;

public class BookDAO extends GenericDAOImpl<Book,Integer>
{
    // do something if needed
    public Boolean isBookinAmanat(Book book)
    {
        Query query = emFactory.getEntityManager().createQuery("SELECT COUNT(a) FROM Amanat a where a.book.id=:bid and a.date3 is null");
        query.setParameter("bid",book.getId());
        if (Integer.parseInt(query.getSingleResult().toString())>0)
            return true;
        else
            return  false;
    }
}
