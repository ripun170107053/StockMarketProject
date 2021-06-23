package stockExchange.dao;

import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stockExchange.entities.StockExchangeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity,Long>
{
    @Query("SELECT c FROM companyEntity c where c.stockExchange = :se")
    public List<companyEntity> getCompaniesListedOn(String se);

    @Query(value = "SELECT c FROM StockExchangeEntity c WHERE c.stockExchange LIKE CONCAT('%',:id,'%') ")
    StockExchangeEntity  findByName(String id);
}
