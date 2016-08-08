package service;

import common.model.Book;
import dao.BookDAO;
import dao.emFactory;

import java.util.List;

public class BookServiceImpl implements BookService
{
    // define all DAOs HERE
    BookDAO bookDAO=new BookDAO();



	//-------------------------------------------------------------   Add Book
    @Override
	public Book Add(Book t) throws Exception
	{
    	emFactory.getEntityManager().getTransaction().begin();
        try
        {
            // Add New Book Business Logic should be HERE
            // Add New Book Business Logic




            Book b=bookDAO.Insert(t);


            emFactory.getEntityManager().getTransaction().commit();
            return b;
        }
        catch (Exception ex)
        {
        	emFactory.getEntityManager().getTransaction().rollback();
            throw new Exception("Œÿ« œ— À»  œ«œÂ Â«");
        }
	}

    //-------------------------------------------------------------   Remove Book
    @Override
    public void Remove(Book t)
	{
    	emFactory.getEntityManager().getTransaction().begin();


        // Remove any Book Business Logic should be HERE


        bookDAO.Delete(t);


        emFactory.getEntityManager().getTransaction().commit();
    }


    //-------------------------------------------------------------   Edit Book
    @Override
    public Book Edit(Book t)
	{
    	emFactory.getEntityManager().getTransaction().begin();


        // Edit Book Business Logic should be HERE


        Book b=bookDAO.Update(t);


        emFactory.getEntityManager().getTransaction().commit();
        return b;

    }


    //-------------------------------------------------------------   Select Books
    @Override
    public List<Book> GetAll()
	{
        return bookDAO.SelectAll();
    }
	
}
