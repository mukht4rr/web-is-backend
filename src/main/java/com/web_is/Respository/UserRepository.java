package com.web_is.Respository;//package com.web_is.Respository;
//
//
//import com.web_is.User.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
//}

import com.web_is.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByRole(String role);
}
