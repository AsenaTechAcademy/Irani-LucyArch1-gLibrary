package common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the amanat database table.
 * 
 */
@Entity
@NamedQuery(name="Amanat.findAll", query="SELECT a FROM Amanat a")
public class Amanat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date1;

	@Temporal(TemporalType.DATE)
	private Date date2;

	@Temporal(TemporalType.DATE)
	private Date date3;

	private Integer penalty;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookid")
	private Book book;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="memberid")
	private Member member;

	public Amanat() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate1() {
		return this.date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return this.date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate3() {
		return this.date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public Integer getPenalty() {
		return this.penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}