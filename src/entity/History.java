/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author user
 */
public class History {
    private Book book;
    private Reader reader;
    private Date takeOn;
    private Date returnDate;

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public Date getTakeOn() {
        return takeOn;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public History(Book book, Reader reader, Date takeOn, Date returnDate) {
        this.book = book;
        this.reader = reader;
        this.takeOn = takeOn;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "History{"
                + "book=" + book + 
                ", reader=" + reader + 
                ", takeOn=" + takeOn + 
                ", returnDate=" + returnDate + '}';
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setTakeOn(Date takeOn) {
        this.takeOn = takeOn;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public History() {
    }
}
