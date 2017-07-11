package main.entities;

/**
 * Created by Dell on 2017/6/27.
 */
public class BookScore {
    private int bookScoreId;
    private Double bookScore;
    private User user;


    private Book book;

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

    public int getBookScoreId() {
        return bookScoreId;
    }

    public void setBookScoreId(int bookScoreId) {
        this.bookScoreId = bookScoreId;
    }

    public Double getBookScore() {
        return bookScore;
    }

    public void setBookScore(Double bookScore) {
        this.bookScore = bookScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookScore bookScore1 = (BookScore) o;

        if (user.getUsername() != bookScore1.user.getUsername()) return false;
        if (book.getBookName() != null ? !book.getBookName().equals(bookScore1.book.getBookName()) : bookScore1.book.getBookName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (book.getBookName() != null ? book.getBookName().hashCode() : 0) + (user.getUsername() != null ? user.getUsername().hashCode() : 0);
        return result;
    }
}
