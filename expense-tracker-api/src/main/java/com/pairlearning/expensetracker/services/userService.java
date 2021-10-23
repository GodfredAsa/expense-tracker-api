package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domian.User;
import com.pairlearning.expensetracker.exceptions.EtAuthException;

/** 2 USED CASES
 *  i. Validate an existing user
 *  ii. register a new user
 *
 */

public interface userService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
