package service;


import java.util.List;

import common.model.Member;
import common.model.Membertype;


public interface MemberService extends npGenericService<Member>
{
	// add additional Interface Services of Non Primary (NP)USs HERE
    public List<Membertype> GetAllMembertypes();
    public Member Add(Member m, int memtypeid);
} 
