package com.pedrovega.operationquasarmlb.db.repository;

import com.pedrovega.operationquasarmlb.db.entity.Satellites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SatellitesRepository extends CrudRepository<Satellites,Long> {

    @Query(value="SELECT * FROM SATELLITES", nativeQuery = true)
    List<Satellites> findAllTransactions();

    Satellites findByName(String name);
}
