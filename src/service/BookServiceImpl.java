package service;


import javax.persistence.EntityManager;

import common.model.Book;
import dao.BookDAO;
import dao.emFactory;

import java.util.List;

public class BookServiceImpl implements BookService
{
    EntityManager em;
    // define all DAOs HERE
    BookDAO bookDAO;

    public BookServiceImpl()
    {
        em=(new emFactory().getEntityManager());
        bookDAO=new BookDAO();
    }


	//-------------------------------------------------------------   Add Book
    @Override
	public Book Add(Book t) throws Exception
	{
        em.getTransaction().begin();
        try
        {
            // Add New Book Business Logic should be HERE
            // Add New Book Business Logic




            Book b=bookDAO.Insert(t,em);


            em.getTransaction().commit();
            return b;
        }
        catch (Exception ex)
        {
            em.getTransaction().rollback();
            throw new Exception("Œÿ« œ— À»  œ«œÂ Â«");
        }
	}

    //-------------------------------------------------------------   Remove Book
    @Override
    public void Remove(Book t)
	{
        em.getTransaction().begin();


        // Remove any Book Business Logic should be HERE


        bookDAO.Delete(t,em);


        em.getTransaction().commit();
    }


    //-------------------------------------------------------------   Edit Book
    @Override
    public Book Edit(Book t)
	{
        em.getTransaction().begin();


        // Edit Book Business Logic should be HERE


        Book b=bookDAO.Update(t,em);


        em.getTransaction().commit();
        return b;

    }


    //-------------------------------------------------------------   Select Books
    @Override
    public List<Book> GetAll()
	{
        em.getTransaction().begin();

        List<Book> x= bookDAO.SelectAll(em);

        em.getTransaction().commit();
        return x;
    }
	
}
