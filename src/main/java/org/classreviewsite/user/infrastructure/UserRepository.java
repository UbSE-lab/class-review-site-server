package org.classreviewsite.user.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.classreviewsite.data.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User findOne(int userNumber){
        return em.find(User.class, userNumber);
    }




}
