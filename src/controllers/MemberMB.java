package controllers;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import common.model.Member;
import common.model.Membertype;
import service.MemberService;
import service.MemberServiceImpl;

import java.util.List;


@ManagedBean
@RequestScoped

public class MemberMB
{
    Member member =new Member();
    MemberService ms=new MemberServiceImpl();

    private String memtypeid;


    public String save() throws Exception
    {
        ms.Add(member,Integer.parseInt(memtypeid));
        member=new Member();
        return "Members";
    }

    public void delete(Member item)
    {
        ms.Remove(item);
    }

    public List<Member> getAllMembers()
    {
        return ms.GetAll();
    }
    public List<Membertype> getAllMembertypes()
    {
        return ms.GetAllMembertypes();
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public String getMemtypeid() {
        return memtypeid;
    }

    public void setMemtypeid(String memtypeid) {
        this.memtypeid = memtypeid;
    }

}
