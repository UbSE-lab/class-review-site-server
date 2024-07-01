package org.classreviewsite.user.infrastructure;

import org.classreviewsite.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserNumber(@Param("userNumber") int userNumber);

    User findByUserNumberAndPassword(@Param("userNumber") int userNumber , @Param("password") String password);

}
