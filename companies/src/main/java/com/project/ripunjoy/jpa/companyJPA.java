package com.project.ripunjoy.jpa;


import com.project.ripunjoy.entities.companyEntity;
import org.springframework.stereotype.Repository;
import stockExchange.entities.StockExchangeEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class companyJPA
{
   // private static companyJPA entityManager;
    @PersistenceContext
    EntityManager entityManager;

    public companyEntity savecompany(String Name) {
        companyEntity cmp = new companyEntity( Name);
        entityManager.persist(cmp);
        return cmp;
    }
    public companyEntity findcompany(companyEntity c) {
        companyEntity cmp = new companyEntity();
        cmp = entityManager.find(companyEntity.class,c);
        return cmp;
    }


    public StockExchangeEntity findexchange(StockExchangeEntity stockexchange) {
        StockExchangeEntity cmp = new StockExchangeEntity();
        cmp = entityManager.find(StockExchangeEntity.class,stockexchange);
        return cmp;
    }

    public companyEntity findById(Long id) {
        return entityManager.find(companyEntity.class, id);// JPA
    }

    public companyEntity update(companyEntity person) {
        return entityManager.merge(person);
    }

    public companyEntity insert(companyEntity person) {
        return entityManager.merge(person);
    }

    public void deleteById(Long id) {
        companyEntity person = findById(id);
        entityManager.remove(person);
    }
}
