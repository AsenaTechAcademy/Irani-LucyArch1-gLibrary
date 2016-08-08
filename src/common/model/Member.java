package common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer allpenalty;

	private String email;

	private String family;

	private String mellino;

	private String mno;

	private String mobile;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date tasviyedate;

	//bi-directional many-to-one association to Amanat
	@OneToMany(mappedBy="member")
	private List<Amanat> amanats;

	//bi-directional many-to-one association to Membertype
	@ManyToOne
	@JoinColumn(name="membertypeid")
	private Membertype membertype;

	public Member() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAllpenalty() {
		return this.allpenalty;
	}

	public void setAllpenalty(Integer allpenalty) {
		this.allpenalty = allpenalty;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getMellino() {
		return this.mellino;
	}

	public void setMellino(String mellino) {
		this.mellino = mellino;
	}

	public String getMno() {
		return this.mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTasviyedate() {
		return this.tasviyedate;
	}

	public void setTasviyedate(Date tasviyedate) {
		this.tasviyedate = tasviyedate;
	}

	public List<Amanat> getAmanats() {
		return this.amanats;
	}

	public void setAmanats(List<Amanat> amanats) {
		this.amanats = amanats;
	}

	public Amanat addAmanat(Amanat amanat) {
		getAmanats().add(amanat);
		amanat.setMember(this);

		return amanat;
	}

	public Amanat removeAmanat(Amanat amanat) {
		getAmanats().remove(amanat);
		amanat.setMember(null);

		return amanat;
	}

	public Membertype getMembertype() {
		return this.membertype;
	}

	public void setMembertype(Membertype membertype) {
		this.membertype = membertype;
	}

}