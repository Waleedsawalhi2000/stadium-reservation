package org.stadium.repository;

import org.stadium.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends AbstractJpaRepository<User, Integer> {
    @Query("select user from User AS user where user.username= :username")
    User findUserByUserName(@Param("username") final String username);

    @Query("select user from User as user where user.email= :email")
    User findUserByEmail(@Param("email") final String email);
}
