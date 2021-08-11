package by.kazakevich.restbooks.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private Long publishingYear;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "author_id", nullable = false)
  private Integer authorId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false, insertable = false,
      updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false, insertable = false,
      updatable = false)
  private Author author;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getPublishingYear() {
    return publishingYear;
  }

  public void setPublishingYear(Long publishingYear) {
    this.publishingYear = publishingYear;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Integer authorId) {
    this.authorId = authorId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
