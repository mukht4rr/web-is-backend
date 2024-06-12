//package com.web_is.User;
//
//import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Entity
//@Table(name = "student")
//public class Student implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long student_id;
//
//    @Column(nullable = false, unique = true)
//    private String registrationNumber;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(nullable = false)
//    private String fullname;
//
//    // Getter and Setter for id
//    public Long getId() {
//        return student_id;
//    }
//
//    public void setId(Long id) {
//        this.student_id = id;
//    }
//
//    // Getter and Setter for registrationNumber
//    public String getRegistrationNumber() {
//        return registrationNumber;
//    }
//
//    public void setRegistrationNumber(String registrationNumber) {
//        this.registrationNumber = registrationNumber;
//    }
//
//    // Getter and Setter for password
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    // Getter and Setter for fullname
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    // UserDetails methods
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.emptyList(); // Or set appropriate authorities
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public String getUsername() {
//        return registrationNumber;
//    }
//}
