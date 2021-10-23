package com.pairlearning.expensetracker.repositories;

import com.pairlearning.expensetracker.domian.User;
import com.pairlearning.expensetracker.exceptions.EtAuthException;

// interacts with DB and affect method operations
public interface UserRepository {
    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
