/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import tools.managers.BookManager;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class HistoryManager {
    private ReaderManager readerManager = new ReaderManager();
    private BookManager booksManager = new BookManager();
    private Scanner scanner = new Scanner(System.in);
    public void addHistoryTo(History[] histories, History history){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] == null){
                histories[i]= history;
                break;
            }
        }
    }

    public History takeOnbook(Book[] books, Reader[] readers) {
        booksManager.printListBooks(books);
        System.out.println("Choose number");
        int ch = scanner.nextInt();
        Book chosenBook = books[ch-1]; 
        System.out.println("--- Список читателей ---");
        readerManager.printListReaders(readers);
        System.out.println("Choose number");
        ch = scanner.nextInt();
        Reader chosenReader = readers[ch-1]; 
        Calendar c = new GregorianCalendar();
        c.getTime();
        History history = new History();
        history.setBook(chosenBook);
        history.setReader(chosenReader);
        history.setTakeOn(c.getTime());
        return history;
    }
    public void printListHistories(History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null){
                System.out.printf("%d. %s%n",i+1,histories[i].toString());
                    }
        }
    }
    public void printListHistories(History[] histories, boolean onHands) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null && ((histories[i].getReturnDate() == null) == onHands)){
                System.out.printf("%d. %s%n",i+1,histories[i].toString());
            }
        }
    }
    public void returnBook(History[] histories){
        System.out.println("return book");
        printListHistories(histories, true);
        System.out.printf("incert number: ");
        int id  = scanner.nextInt();
        Calendar c = new GregorianCalendar();
        histories[id - 1].setReturnDate(c.getTime());
    }
}
