package com.app.Java.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Java.Model.Address;

@Repository
public interface AddressrRepo extends JpaRepository<Address, Integer>{

}
