package com.platformCommons.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformCommons.model.Address;

@Repository
public interface AddressrRepo extends JpaRepository<Address, Integer>{

}
