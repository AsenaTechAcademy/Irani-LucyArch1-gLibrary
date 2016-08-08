package common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the membertype database table.
 * 
 */
@Entity
@NamedQuery(name="Membertype.findAll", query="SELECT m FROM Membertype m")
public class Membertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date deleteddate;

	private Boolean isactive;

	private Integer maxbooks;

	private Integer maxdays;

	private Integer maxpenalty;

	private Integer penaltyperday;

	private String title;

	//bi-directional many-to-one association to Member
	@OneToMany(mappedBy="membertype")
	private List<Member> members;

	public Membertype() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDeleteddate() {
		return this.deleteddate;
	}

	public void setDeleteddate(Date deleteddate) {
		this.deleteddate = deleteddate;
	}

	public Boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Integer getMaxbooks() {
		return this.maxbooks;
	}

	public void setMaxbooks(Integer maxbooks) {
		this.maxbooks = maxbooks;
	}

	public Integer getMaxdays() {
		return this.maxdays;
	}

	public void setMaxdays(Integer maxdays) {
		this.maxdays = maxdays;
	}

	public Integer getMaxpenalty() {
		return this.maxpenalty;
	}

	public void setMaxpenalty(Integer maxpenalty) {
		this.maxpenalty = maxpenalty;
	}

	public Integer getPenaltyperday() {
		return this.penaltyperday;
	}

	public void setPenaltyperday(Integer penaltyperday) {
		this.penaltyperday = penaltyperday;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member addMember(Member member) {
		getMembers().add(member);
		member.setMembertype(this);

		return member;
	}

	public Member removeMember(Member member) {
		getMembers().remove(member);
		member.setMembertype(null);

		return member;
	}

}