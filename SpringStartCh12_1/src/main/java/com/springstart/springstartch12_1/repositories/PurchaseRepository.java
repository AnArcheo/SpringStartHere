package com.springstart.springstartch12_1.repositories;

import com.springstart.springstartch12_1.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) { // constructor injection to get jdbcTemplate
        this.jdbc = jdbc;
    }

    //method to add new record
    public void storePurchase(Purchase purchase){
        //string query; ? ? replace queries parameter values
        String sql = "INSERT INTO purchase VALUES(NULL, ?, ?)"; //ID=null because DBMS is configured to generate this vales

        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    //method to select records
    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * FROM purchase";

        //RowMapper that tells jdbcTemplate how to map row in the result set into Purchase
        //r is ResultSet
        //i row number
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        // send select query using the query method
        //row mapper object for JdbcTemplate
        return jdbc.query(sql, purchaseRowMapper);
    }
}
