package ipo.dao;

import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import ipo.entities.ipoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stockExchange.entities.StockExchangeEntity;

import java.util.List;

@Repository
public interface IpoRepository extends JpaRepository<ipoDetailsEntity,Long>
{


    @Query("SELECT c from ipoDetailsEntity c ORDER BY c.openDateTime ")
    public List<ipoDetailsEntity> sortIPO() ;
}
