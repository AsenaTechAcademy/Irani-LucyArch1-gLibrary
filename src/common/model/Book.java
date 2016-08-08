package common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String author;

	private String bno;

	@Temporal(TemporalType.DATE)
	private Date deleteddate;

	private String isbn;

	private Boolean isreference;

	private Integer pages;

	private String title;

	//bi-directional many-to-one association to Amanat
	@OneToMany(mappedBy="book")
	private List<Amanat> amanats;

	public Book() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBno() {
		return this.bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public Date getDeleteddate() {
		return this.deleteddate;
	}

	public void setDeleteddate(Date deleteddate) {
		this.deleteddate = deleteddate;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getIsreference() {
		return this.isreference;
	}

	public void setIsreference(Boolean isreference) {
		this.isreference = isreference;
	}

	public Integer getPages() {
		return this.pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Amanat> getAmanats() {
		return this.amanats;
	}

	public void setAmanats(List<Amanat> amanats) {
		this.amanats = amanats;
	}

	public Amanat addAmanat(Amanat amanat) {
		getAmanats().add(amanat);
		amanat.setBook(this);

		return amanat;
	}

	public Amanat removeAmanat(Amanat amanat) {
		getAmanats().remove(amanat);
		amanat.setBook(null);

		return amanat;
	}

}