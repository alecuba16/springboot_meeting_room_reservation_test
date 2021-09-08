package com.alecuba.springdatasetprovider.data.repository;

import com.alecuba.springdatasetprovider.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest,Long> {
}
