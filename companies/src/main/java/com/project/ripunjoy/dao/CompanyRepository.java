package com.project.ripunjoy.dao;

import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
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



}
