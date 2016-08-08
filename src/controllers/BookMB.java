package controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import common.model.Book;
import service.BookService;
import service.BookServiceImpl;

@ManagedBean
@RequestScoped
public class BookMB
{
    Book book =new Book();
    BookService bs=new BookServiceImpl();


    public String save()
    {
        try
        {
            bs.Add(book);
            book = new Book();
            return "Books";
        }
        catch (Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,ex.getMessage(), "");
            RequestContext.getCurrentInstance().showMessageInDialog(message);

            return "Books";

        }
    }

    public void delete(Book item)
    {
        bs.Remove(item);
    }

    public List<Book> getAllBooks()
    {
        List<Book> x=bs.GetAll();
        return x;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
