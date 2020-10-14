/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Reader;
import entity.User;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class UserManager {

    public User regUser() {
        ReaderManager readerManager = new ReaderManager();
        Reader reader  = readerManager.createReader();
        User user = createUser(reader) ;
        return user;
    }

    public User signUp(User[] users) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- d[jl user---");
        System.out.print("user Login: ");
        String login = scanner.nextLine();
        System.out.print("User password: ");
        String password = scanner.nextLine();
        for (int i = 0 ; i < users.length ; i++){
            if (users[i].getLogin().equals(login) && users[i].getPassword().equals(password)){
                return users[i];
            }
        }
        return null;
    }
    private User createUser(Reader reader){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Созданиеgdfghd ---");
        System.out.print("user Login: ");
        user.setLogin(scanner.nextLine());
        System.out.print("User password: ");
        user.setPassword(scanner.nextLine());
        user.setReader(reader);
        return user;
    }
    
}
