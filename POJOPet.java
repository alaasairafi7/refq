/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Ameer
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ameer
 */
@Entity
@Table(name = "Pet")
public class POJOPet implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PetID")
    private int PetID;
    @Column(name = "UserName", nullable = true)
    private String UserName;
    @Column(name = "PetImage")
    private String Pet_Image;
    @Column(name = "PetName")
    private String Pet_Name;
    @Column(name = "Pet_Type")
    private String PetType;
    @Column(name = "Breed")
    private String Breed;
    @Column(name = "Pet_Age")
    private int Pet_Age;
    @Column(name = "Pet_Gender")
    private String Pet_Gender;
    @Column(name = "Description")
    private String Description;
    
  


    public POJOPet() {
    }

    public POJOPet(int PetID, String UserName, String Pet_Image, String Pet_Name, String PetType, String Breed, int Pet_Age, String Pet_Gender, String Description) {
        this.PetID = PetID;
        this.UserName = UserName;
        this.Pet_Image = Pet_Image;
        this.Pet_Name = Pet_Name;
        this.PetType = PetType;
        this.Breed = Breed;
        this.Pet_Age = Pet_Age;
        this.Pet_Gender = Pet_Gender;
        this.Description = Description;
    }

    public int getPetID() {
        return PetID;
    }

    public void setPetID(int PetID) {
        this.PetID = PetID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPet_Image() {
        return Pet_Image;
    }

    public void setPet_Image(String Pet_Image) {
        this.Pet_Image = Pet_Image;
    }

    public String getPet_Name() {
        return Pet_Name;
    }

    public void setPet_Name(String Pet_Name) {
        this.Pet_Name = Pet_Name;
    }

    public String getPetType() {
        return PetType;
    }

    public void setPetType(String PetType) {
        this.PetType = PetType;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String Breed) {
        this.Breed = Breed;
    }

    public int getPet_Age() {
        return Pet_Age;
    }

    public void setPet_Age(int Pet_Age) {
        this.Pet_Age = Pet_Age;
    }

    public String getPet_Gender() {
        return Pet_Gender;
    }

    public void setPet_Gender(String Pet_Gender) {
        this.Pet_Gender = Pet_Gender;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    

}
