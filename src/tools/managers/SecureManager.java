/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.User;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SecureManager {
    private Scanner scan = new Scanner(System.in);
    public User checkTask(User[] users) {
        int numTask = 4;
        boolean isAsk = true;
        UserManager userManager = new UserManager();
        do{
            System.out.printf("0 - exit%n1 - Sign up%n2 - Log in%nSelect task: ");
            String task = scan.nextLine();
            try{
                numTask = Integer.parseInt(task);
                if(numTask == 0){
                    System.exit(0);
                } else if(numTask == 1){
                    return userManager.regUser();
                } else if (numTask == 2){
                    return userManager.signUp(users);
                } else{
                    
                }
            } catch (Exception e){
                System.out.println("This task does't exist");
            }
        }while(true);
        
    }
    
}
