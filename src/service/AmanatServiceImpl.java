package service;


import common.model.Amanat;
import common.model.Book;
import common.model.Member;
import dao.AmanatDAO;
import dao.BookDAO;
import dao.MemberDAO;
import dao.emFactory;

import java.util.List;

/**
 * Created by Irani on 10/9/2015.
 */
public class AmanatServiceImpl implements AmanatService
{
    // define all DAOs HERE
    BookDAO bookDAO=new BookDAO();
    MemberDAO memberDAO=new MemberDAO();
    AmanatDAO amanatDAO=new AmanatDAO();



    public Amanat AddNewAmanat(Amanat amanat, int bookID, int memberID) throws Exception
    {
    	emFactory.getEntityManager().getTransaction().begin();

        try {

            //Add Amanat Business Logic
            Book book = bookDAO.SelectById(bookID);
            Member member = memberDAO.SelectById(memberID);

            //Logic 0: is Book in Amanat
            if (bookDAO.isBookinAmanat(book))
                throw new Exception("کتاب موجود نمی باشد و امانت است");

            // Logic 1: Book should not be reference
            if (book.getIsreference())
                throw new Exception("کتاب مرجع می باشد و قابل امانت نیست");

            // Logic 2: Member should not have penalty
            if (member.getAllpenalty()>0)
                throw new Exception("عضو جریمه دارد و نمی تواند کتاب امانت بگیرد");


            amanat.setBook(book);
            amanat.setMember(member);
            //amanat.setDate2(currentDate + member.getMembertype().getMaxdays());
            //amanat.setDate1(currentDate);

            amanatDAO.Insert(amanat);

            emFactory.getEntityManager().getTransaction().commit();
        }
        catch (Exception ex)
        {
        	emFactory.getEntityManager().getTransaction().rollback();
            throw new Exception(ex.getMessage());
        }


        return null;
    }

    public List<Amanat> GetAllAmanat()
    {
        return amanatDAO.SelectAll();
    }
}
