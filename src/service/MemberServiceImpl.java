package service;


import javax.persistence.EntityManager;

import common.model.Member;
import common.model.Membertype;
import dao.MemberDAO;
import dao.MembertypeDAO;
import dao.emFactory;

import java.util.List;


public class MemberServiceImpl implements MemberService
{
	EntityManager em;
	// define all DAOs HERE
    MemberDAO memberDAO;
    MembertypeDAO membertypeDAO;

	public MemberServiceImpl()
	{
		em=(new emFactory().getEntityManager());
		memberDAO=new MemberDAO();
        membertypeDAO=new MembertypeDAO();
	}


	public Member Add(Member t)
	{
        em.getTransaction().begin();

        // Add New Book Business Logic should be HERE

        Member m=memberDAO.Insert(t,em);

        em.getTransaction().commit();
		return m;
    }

    public Member Add(Member m,int memtypeid)
    {
        em.getTransaction().begin();


        // Add New Book Business Logic should be HERE

        m.setAllpenalty(0);
        m.setTasviyedate(null);
        m.setMembertype(membertypeDAO.SelectById(memtypeid,em));

        m=memberDAO.Insert(m,em);

        em.getTransaction().commit();
        return m;
    }

    public void Remove(Member t)
	{
        em.getTransaction().begin();

        // Remove any Book Business Logic should be HERE

		memberDAO.Delete(t,em);
        em.getTransaction().commit();
    }

	public Member Edit(Member t)
	{
        em.getTransaction().begin();

        // Edit Book Business Logic should be HERE
		
		Member m=memberDAO.Update(t,em);
        em.getTransaction().commit();
        return m;
	}

	public List<Member> GetAll()
	{
		return memberDAO.SelectAll(em);
	}

    public List<Membertype> GetAllMembertypes()
    {
        return membertypeDAO.SelectAll(em);
    }

}
