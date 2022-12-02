package org.alicoder.spring.contactmanagement.repository;


import org.alicoder.spring.contactmanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("select u from Users u where u.userId=:id")
    Users findUserById(@Param("id") int id);
    List<Users> findByFirstNameLike(String firstName);

    List<Users> findByEmail(String email);

    List<Users> findByLastNameLike(String lastName);

    boolean existsByEmailAndPassword(String email, String password);

    @Modifying
    @Transactional
    @Query("update Users u set u.firstName=:fname,u.lastName=:lname,u.email=:email, u.password = :password where u.userId=:id")
    void editUser(@Param("id") int id, @Param("fname")String fname, @Param("lname") String lname,
                  @Param("email")String email, @Param("password")String password);
}
