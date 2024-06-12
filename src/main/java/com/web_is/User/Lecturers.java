package com.web_is.User;

import jakarta.persistence.*;

@Entity
@Table(name = "lecturers")
public class Lecturers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private int lecturerId;

    @Column(name = "lecturer_name")
    private String lecturerName;

    @Column(name = "lecturer_email")
    private String lecturerEmail;

    @Column(name = "lecturer_phone")
    private int lecturerPhone;

    @Column(name = "lecturer_password")
    private String lecturerPassword;

    public int getLecturerId(){
        return lecturerId;
    }

    public void setLecturerId(int lecturerId){
        this.lecturerId = lecturerId;
    }

    public String getLecturerName(){
        return lecturerName;
    }

    public void setLecturerName(String lecturerName){
        this.lecturerName = lecturerName;
    }

    public String getLecturerEmail(){
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail){
        this.lecturerEmail = lecturerEmail;
    }

    public int getLecturerPhone(){
        return lecturerPhone;
    }

    public void setLecturerPhone(int lecturerPhone){
        this.lecturerPhone = lecturerPhone;
    }

    public String getLecturerPassword(){
        return lecturerPassword;
    }

    public void setLecturerPassword(String lecturerPassword){
        this.lecturerPassword = lecturerPassword;
    }



}
