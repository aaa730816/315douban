package main.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class BookLcom {
    private int bookLcomId;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String bookLcomContent;
    private Timestamp bookLcomDate;
    private Integer bookLcomLike;
    private User user;
    private Book book;
    private Set<Comment> comments=new HashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBookLcomId() {
        return bookLcomId;
    }

    public void setBookLcomId(int bookLcomId) {
        this.bookLcomId = bookLcomId;
    }

    public String getBookLcomContent() {
        return bookLcomContent;
    }

    public void setBookLcomContent(String bookLcomContent) {
        this.bookLcomContent = bookLcomContent;
    }

    public Timestamp getBookLcomDate() {
        return bookLcomDate;
    }

    public void setBookLcomDate(Timestamp bookLcomDate) {
        this.bookLcomDate = bookLcomDate;
    }

    public Integer getBookLcomLike() {
        return bookLcomLike;
    }

    public void setBookLcomLike(Integer bookLcomLike) {
        this.bookLcomLike = bookLcomLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLcom bookLcom = (BookLcom) o;

        if (user != null ? !user.getUsername().equals(bookLcom.user.getUsername()) : bookLcom.user.getUsername() != null)
            return false;
        if (book != null ? !book.getBookName().equals(bookLcom.book.getBookName()) : bookLcom.book.getBookName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(book != null ? book.getBookName().hashCode() : 0) + (user != null ? user.getUsername().hashCode() : 0);

        return result;
    }
}
