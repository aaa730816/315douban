package main.entities;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class Book {
    private int bookId;
    private String bookName;
    private String bookWri;
    private String bookPub;
    private String bookDate;
    private Integer bookPage;
    private Integer bookPrice;
    private String bookIsbn;
    private String bookIntro;
    private String bookWriIntro;
    private String bookCata;
    private String bookImg;
    private Double bookSc;
    private Double bookDbsc;
    private Long bookScTime;

    private Set<BookScom> bookScoms;
    private Set<BookLcom> bookLcoms;

    public Set<BookScom> getBookScoms() {
        return bookScoms;
    }

    public void setBookScoms(Set<BookScom> bookScoms) {
        this.bookScoms = bookScoms;
    }

    public Set<BookLcom> getBookLcoms() {
        return bookLcoms;
    }

    public void setBookLcoms(Set<BookLcom> bookLcoms) {
        this.bookLcoms = bookLcoms;
    }

    public Long getBookScTime() {
        return bookScTime;
    }

    public void setBookScTime(Long bookScTime) {
        this.bookScTime = bookScTime;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWri() {
        return bookWri;
    }

    public void setBookWri(String bookWri) {
        this.bookWri = bookWri;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public Integer getBookPage() {
        return bookPage;
    }

    public void setBookPage(Integer bookPage) {
        this.bookPage = bookPage;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getBookWriIntro() {
        return bookWriIntro;
    }

    public void setBookWriIntro(String bookWriIntro) {
        this.bookWriIntro = bookWriIntro;
    }

    public String getBookCata() {
        return bookCata;
    }

    public void setBookCata(String bookCata) {
        this.bookCata = bookCata;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Double getBookSc() {
        return bookSc;
    }

    public void setBookSc(Double bookSc) {
        this.bookSc = bookSc;
    }

    public Double getBookDbsc() {
        return bookDbsc;
    }

    public void setBookDbsc(Double bookDbsc) {
        this.bookDbsc = bookDbsc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (bookWri != null ? !bookWri.equals(book.bookWri) : book.bookWri != null) return false;
        if (bookPub != null ? !bookPub.equals(book.bookPub) : book.bookPub != null) return false;
        if (bookDate != null ? !bookDate.equals(book.bookDate) : book.bookDate != null) return false;
        if (bookPage != null ? !bookPage.equals(book.bookPage) : book.bookPage != null) return false;
        if (bookPrice != null ? !bookPrice.equals(book.bookPrice) : book.bookPrice != null) return false;
        if (bookIsbn != null ? !bookIsbn.equals(book.bookIsbn) : book.bookIsbn != null) return false;
        if (bookIntro != null ? !bookIntro.equals(book.bookIntro) : book.bookIntro != null) return false;
        if (bookWriIntro != null ? !bookWriIntro.equals(book.bookWriIntro) : book.bookWriIntro != null) return false;
        if (bookCata != null ? !bookCata.equals(book.bookCata) : book.bookCata != null) return false;
        if (bookImg != null ? !bookImg.equals(book.bookImg) : book.bookImg != null) return false;
        if (bookSc != null ? !bookSc.equals(book.bookSc) : book.bookSc != null) return false;
        if (bookDbsc != null ? !bookDbsc.equals(book.bookDbsc) : book.bookDbsc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookWri != null ? bookWri.hashCode() : 0);
        result = 31 * result + (bookPub != null ? bookPub.hashCode() : 0);
        result = 31 * result + (bookDate != null ? bookDate.hashCode() : 0);
        result = 31 * result + (bookPage != null ? bookPage.hashCode() : 0);
        result = 31 * result + (bookPrice != null ? bookPrice.hashCode() : 0);
        result = 31 * result + (bookIsbn != null ? bookIsbn.hashCode() : 0);
        result = 31 * result + (bookIntro != null ? bookIntro.hashCode() : 0);
        result = 31 * result + (bookWriIntro != null ? bookWriIntro.hashCode() : 0);
        result = 31 * result + (bookCata != null ? bookCata.hashCode() : 0);
        result = 31 * result + (bookImg != null ? bookImg.hashCode() : 0);
        result = 31 * result + (bookSc != null ? bookSc.hashCode() : 0);
        result = 31 * result + (bookDbsc != null ? bookDbsc.hashCode() : 0);
        return result;
    }
}
