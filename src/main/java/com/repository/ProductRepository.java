package com.repository;

import com.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Product> rowMapper = new BeanPropertyRowMapper(Product.class);


    public List<Product> getProducts() {

        String sql = "select * from product";

        return jdbcTemplate.query(sql , rowMapper);

    }



    public int saveProduct(Product product) {
        String sql = "insert into product( pname , price , description ) values ( ? , ? , ? )";

        int row = jdbcTemplate.update(sql , product.getPname() , product.getPrice() , product.getDescription());

        return row;
    }



    public Product saveProductAndReturnKeys(Product product) {

        String sql = "insert into product( pname , price , description ) values ( ? , ? , ? )";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rows = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql , PreparedStatement.RETURN_GENERATED_KEYS);

                ps.setString(1 , product.getPname());
                ps.setBigDecimal(2 , product.getPrice());
                ps.setString(3 , product.getDescription());

                return ps;
            }
        }, keyHolder);

        if(rows>0) {
            product.setPid(keyHolder.getKey().intValue());
            return product;
        } else {
            return null;
        }

    }



}
