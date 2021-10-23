package com.pairlearning.expensetracker.repositories;
import com.pairlearning.expensetracker.domian.User;
import com.pairlearning.expensetracker.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_CREATE =
            "INSERT INTO ET_USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (NEXTVAL('ET_USERS_SEQ'), ?, ?, ?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer create(String firstName, String lastName,
                          String email, String password) throws EtAuthException {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, email);
                ps.setString(1, password);
                return ps;

            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("USER_ID");

        }catch (Exception e){
            throw new EtAuthException("Invalid Details. Account not created");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }
}



