package main.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class BookScom {
    private int bookScomId;
    private String bookScomContent;
    private Timestamp bookScomDate;
    private Integer bookScomLike;
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

    public int getBookScomId() {
        return bookScomId;
    }

    public void setBookScomId(int bookScomId) {
        this.bookScomId = bookScomId;
    }

    public String getBookScomContent() {
        return bookScomContent;
    }

    public void setBookScomContent(String bookScomContent) {
        this.bookScomContent = bookScomContent;
    }

    public Timestamp getBookScomDate() {
        return bookScomDate;
    }

    public void setBookScomDate(Timestamp bookScomDate) {
        this.bookScomDate = bookScomDate;
    }

    public Integer getBookScomLike() {
        return bookScomLike;
    }

    public void setBookScomLike(Integer bookScomLike) {
        this.bookScomLike = bookScomLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookScom bookScom = (BookScom) o;

        if (user != null ? !user.getUsername().equals(bookScom.user.getUsername()) : bookScom.user.getUsername() != null)
            return false;
        if (book != null ? !book.getBookName().equals(bookScom.book.getBookName()) : bookScom.book.getBookName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(book != null ? book.getBookName().hashCode() : 0) + (user != null ? user.getUsername().hashCode() : 0);
        return result;
    }
}
