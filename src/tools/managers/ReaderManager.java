/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReaderManager {
    public Reader createReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание книги ---");
        System.out.print("Reader name: ");
        reader.setName(scanner.nextLine());
        System.out.print("Reader last name: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Reader Phone: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
    public void addReaderToArray(Reader reader, Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] == null){
                readers[i]=reader;
                break;
            }
        }
    }

    public void printListReaders(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] != null){
                System.out.printf("%d. %s%n",i+1,readers[i].toString());
                    }
        }
    }
}
