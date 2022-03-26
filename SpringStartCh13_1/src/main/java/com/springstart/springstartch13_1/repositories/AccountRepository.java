package com.springstart.springstartch13_1.repositories;

import com.springstart.springstartch13_1.model.Account;
import com.springstart.springstartch13_1.model.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;

    // constructor dependency injection to get JdbcTemplate object to work with database
    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //get details of the account by sending select query to the DBMS
    //RowMapper is used to tell JdbcTemplate how to map row in the result to the model
    public Account findAccountById(long id){
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    //change amount in the account by sending UPDATE query
    public void changeAmount(long id, BigDecimal amount){
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }

    //get all accounts details from the database
    public List<Account> findAllAccounts(){
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }
}
