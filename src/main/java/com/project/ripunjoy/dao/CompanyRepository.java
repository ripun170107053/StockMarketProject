package com.project.ripunjoy.dao;

import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import excel.entities.stockPriceEntity;
import excel.models.stockPriceModel;
import ipo.entities.ipoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<companyEntity,Long>
{


    @Query(value = "SELECT c FROM companyEntity c WHERE c.companyName LIKE CONCAT('%',:companyName,'%') ")
    List<companyEntity> findByPattern(String companyName);

    @Query(value = "SELECT i FROM ipoDetailsEntity i WHERE i.companyName = :id")
    Optional<ipoDetailsEntity> ipoToCompany(String id);

    @Query(value = "SELECT i FROM companyEntity i WHERE i.companyName = :id")
    Optional<companyEntity> findByName(String id);

    @Query(value = "SELECT c FROM stockPriceEntity c WHERE c.companyCode = :id")
    List<stockPriceEntity> getStocksForThisCompanyz(Long id);

//    @Query(value = "INSERT into ipo ")
//    void addIpoToCompanyz(String companyName, ipoDetailsEntity ipo);
}
