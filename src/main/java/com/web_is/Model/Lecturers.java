package com.web_is.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

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
    private String lecturerPhone;

    @Column(name = "lecturer_password")
    private String lecturerPassword;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LecturerCourse> lecturerCourses;

    @Column(name = "role")
    private String role = "lecturer"; // default role

    // existing getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public String getLecturerPhone(){
        return lecturerPhone;
    }

    public void setLecturerPhone(String lecturerPhone){
        this.lecturerPhone = lecturerPhone;
    }

    public String getLecturerPassword(){
        return lecturerPassword;
    }

    public void setLecturerPassword(String lecturerPassword){
        this.lecturerPassword = lecturerPassword;
    }

    public List<LecturerCourse> getLecturerCourses() {
        return lecturerCourses;
    }

    public void setLecturerCourses(List<LecturerCourse> lecturerCourses) {
        this.lecturerCourses = lecturerCourses;
    }



}
