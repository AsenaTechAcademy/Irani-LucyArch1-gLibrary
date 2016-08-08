package service;

import common.model.Member;
import common.model.Membertype;
import dao.MemberDAO;
import dao.MembertypeDAO;
import dao.emFactory;

import java.util.List;


public class MemberServiceImpl implements MemberService
{
	// define all DAOs HERE
    MemberDAO memberDAO=new MemberDAO();
    MembertypeDAO membertypeDAO=new MembertypeDAO();



	public Member Add(Member t)
	{
		emFactory.getEntityManager().getTransaction().begin();

        // Add New Book Business Logic should be HERE

        Member m=memberDAO.Insert(t);

        emFactory.getEntityManager().getTransaction().commit();
		return m;
    }

    public Member Add(Member m,int memtypeid)
    {
    	emFactory.getEntityManager().getTransaction().begin();


        // Add New Book Business Logic should be HERE

        m.setAllpenalty(0);
        m.setTasviyedate(null);
        m.setMembertype(membertypeDAO.SelectById(memtypeid));

        m=memberDAO.Insert(m);

        emFactory.getEntityManager().getTransaction().commit();
        return m;
    }

    public void Remove(Member t)
	{
    	emFactory.getEntityManager().getTransaction().begin();

        // Remove any Book Business Logic should be HERE

		memberDAO.Delete(t);
		emFactory.getEntityManager().getTransaction().commit();
    }

	public Member Edit(Member t)
	{
		emFactory.getEntityManager().getTransaction().begin();

        // Edit Book Business Logic should be HERE
		
		Member m=memberDAO.Update(t);
		emFactory.getEntityManager().getTransaction().commit();
        return m;
	}

	public List<Member> GetAll()
	{
		return memberDAO.SelectAll();
	}

    public List<Membertype> GetAllMembertypes()
    {
        return membertypeDAO.SelectAll();
    }

}
