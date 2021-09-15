package com.address.dao;

import com.address.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoImp implements AddressDao {

    private JdbcTemplate jdbcTemplate;

    public AddressDaoImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int create(Address address) {
        String sql = "insert into addresses(name,email,gender,city) values(?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, address.getName(), address.getEmail(), address.getGender(), address.getCity());

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Address> read() {
        List<Address> addressList = jdbcTemplate.query("SELECT * FROM addresses", new RowMapper<Address>() {

            @Override
            public Address mapRow(ResultSet rs, int i) throws SQLException {
                Address address = new Address();

                address.setId(rs.getInt("id"));
                address.setName(rs.getString("name"));
                address.setEmail(rs.getString("email"));
                address.setGender(rs.getString("gender"));
                address.setCity(rs.getString("city"));
                return address;
            }

        });

        return addressList;
    }

    @Override
    public Address findAddressById(int addressId) {
        Address address = jdbcTemplate.queryForObject("SELECT * FROM addresses where id=?",
                new Object[]{addressId}, new RowMapper<Address>() {

                    @Override
                    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Address address = new Address();

                        address.setId(rs.getInt("id"));
                        address.setName(rs.getString("name"));
                        address.setEmail(rs.getString("email"));
                        address.setGender(rs.getString("gender"));
                        address.setCity(rs.getString("city"));

                        return address;
                    }

                });

        return address;
    }

    @Override
    public int update(Address address,int addressId) {
        String sql = "update  addresses set name=?, email=?, gender=?, city=? where id=?";

        try {

            return jdbcTemplate.update(sql,
                    address.getName(), address.getEmail(), address.getGender(), address.getCity(), address.getId());

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int addressId) {
        String sql = "delete from addresses where id=?";

        try {

            return jdbcTemplate.update(sql, addressId);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
