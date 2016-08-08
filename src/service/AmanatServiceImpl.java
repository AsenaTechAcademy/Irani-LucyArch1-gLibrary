package service;


import javax.persistence.EntityManager;

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
    EntityManager em;
    // define all DAOs HERE
    BookDAO bookDAO;
    MemberDAO memberDAO;
    AmanatDAO amanatDAO;

    public AmanatServiceImpl()
    {
        em=(new emFactory().getEntityManager());
        bookDAO=new BookDAO();
        memberDAO=new MemberDAO();
        amanatDAO=new AmanatDAO();
    }




    public Amanat AddNewAmanat(Amanat amanat, int bookID, int memberID) throws Exception
    {
        em.getTransaction().begin();

        try {


            //Add Amanat Business Logic
            Book book = bookDAO.SelectById(bookID, em);
            Member member = memberDAO.SelectById(memberID, em);

            //Logic 0: is Book in Amanat
            if (bookDAO.isBookinAmanat(book,em))
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

            amanatDAO.Insert(amanat,em);

            em.getTransaction().commit();
        }
        catch (Exception ex)
        {
        	em.getTransaction().rollback();
            throw new Exception(ex.getMessage());
        }


        return null;
    }

    public List<Amanat> GetAllAmanat()
    {
        return amanatDAO.SelectAll(em);
    }
}
