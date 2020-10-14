/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import tools.managers.SecureManager;
import entity.Reader;
import entity.Book;
import entity.History;
import entity.User;
import java.util.Scanner;
import tools.managers.BookManager;
import tools.savers.BookSaver;
import tools.managers.HistoryManager;
import tools.savers.HistorySaver;
import tools.managers.ReaderManager;
import tools.savers.ReaderSaver;
import tools.savers.UserSaver;

/**
 *
 * @author sillamae kutsekool
 */
class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];
    private History[] histories = new History[100];
    private User[] users = new User[100];
    private ReaderManager readerManager = new ReaderManager();
    private BookManager booksManager = new BookManager();
    private HistoryManager historyManager = new HistoryManager();
    private SecureManager secureManager = new SecureManager();
    private User loginedUser ;
    

    public App() {
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadFile();
        ReaderSaver readerSaver = new ReaderSaver();
        readers = readerSaver.loadFile();
        HistorySaver historySaver = new HistorySaver();
        histories = historySaver.loadFile();
        
    }
    
    public void run(){
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask(users);
        UserSaver userSaver = new UserSaver();
        userSaver.saveUsers(users);
        boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Посмотреть список книг");
            System.out.println("3. Зарегистрировать нового читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Посмотреть histoty");
            System.out.println("6. Return book");
            
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("---- Конец программы ----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("---- Добавить новую книгу ----");
                    // создадим объект книги
                    Book book = booksManager.createBook();
                    booksManager.addBookTo(books, book);
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);
                    break;
                case "2":
                    System.out.println("--- Cписок книг ---");
                    booksManager.printListBooks(books);
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    Reader reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader,readers);
                    
                    ReaderSaver readerSaver = new ReaderSaver();
                    readerSaver.saveReaders(readers);
                    readerManager.printListReaders(readers);
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    readerManager.printListReaders(readers);
                    
                    break;
                case "5":
                    System.out.println("--- выдать книгу ---");
                    History history = historyManager.takeOnbook(books, readers);
                    historyManager.addHistoryTo(histories, history);
                    HistorySaver historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    System.out.println("");
                    break;
                case "6":
                    historyManager.printListHistories(histories);
                    break;
                case "7":
                    historyManager.returnBook(histories);
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
