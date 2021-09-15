package com.address.dao;

import com.address.model.Address;

import java.util.List;

public interface AddressDao {
    public int create(Address address);

    public List<Address> read();

    public Address findAddressById(int addressId);

    public int update(Address address,int addressId);

    public int delete(int addressId);

}
