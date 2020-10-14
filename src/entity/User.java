/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author user
 */
public class User {
    private String login;
    private String password;
    private Reader reader;

    public User(String login, String password, Reader reader) {
        this.login = login;
        this.password = password;
        this.reader = reader;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Reader getReader() {
        return reader;
    }

    @Override
    public String toString() {
        return "User{" 
                + "login=" + login 
                + ", password=" + password 
                + ", reader=" + reader.getName()
                + ", reader=" + reader.getLastname() + '}';
    }


}
