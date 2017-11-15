package org.javaee.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
@NamedQueries({@NamedQuery(name="findAllBooks",query="SELECT b FROM Book b"),
				@NamedQuery(name="findBookByTitle", query="SELECT b FROM Book b WHERE b.title='H2G2'")})
public class Book {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private Long id;
	@NotNull(message="The field must not be empty!")
	private String title;
	@NotNull(message="The field must not be empty!")
	private String description;
	@Min(value=1)
	@NotNull(message="the value of this field must be at least 1")
	private Double price;
	@NotNull(message="the value of this field must be at least 1")
	@Column(name="isbn")
	private String isbn;
	@Column(name="number_of_pages")
	private Integer numberOfPage;
	@NotNull
	@Size(min=7)
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
	private String email;
	
	public Book() {
	}
	
	public Book(@NotNull(message = "The field must not be empty!") String title,
			@NotNull(message = "The field must not be empty!") String description,
			@Min(1) @NotNull(message = "the value of this field must be at least 1") Double price,
			@NotNull(message = "the value of this field must be at least 1") String isbn, Integer numberOfPage,
			@NotNull @Size(min = 7) @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?") String email) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.numberOfPage = numberOfPage;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(Integer numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((numberOfPage == null) ? 0 : numberOfPage.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numberOfPage == null) {
			if (other.numberOfPage != null)
				return false;
		} else if (!numberOfPage.equals(other.numberOfPage))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", description=" + description + ", price=" + price + ", isbn=" + isbn
				+ ", numberOfPage=" + numberOfPage + ", email=" + email + "]";
	}

	
	
}
