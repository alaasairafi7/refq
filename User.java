/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ameer
 */
@Entity
@Table(name = "User")
public class User implements java.io.Serializable {

    @Id
    @Column(name = "UserName")
    private String UserName;
    @Column(name = "F_Name")
    private String firstName;
    @Column(name = "L_Name")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "PhonoNumber")
    private int phonoNumber;
    @Column(name = "City")
    private String city;
    @Column(name = "DateOfBirth")
    private String DateOfBirth;

    public User() {
    }

    public User(String UserName, String firstName, String lastName, String email, String password, int phonoNumber, String city, String DateOfBirth) {
        this.UserName = UserName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phonoNumber = phonoNumber;
        this.city = city;
        this.DateOfBirth = DateOfBirth;
    }

    public User(String userName, String firstName, String lastName, String email, String password, String phonoNumber, String city, String dateOfBirth) {

    }

    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhonoNumber() {
        return phonoNumber;
    }

    public void setPhonoNumber(int phonoNumber) {
        this.phonoNumber = phonoNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

}
