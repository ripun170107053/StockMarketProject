package stockExchange.dao;

import com.project.ripunjoy.entities.sectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import stockExchange.entities.StockExchangeEntity;

import java.util.List;

public interface sectorRepository extends JpaRepository<sectorEntity,Long>
{
    @Query("select s from sectorEntity s where s.sectorName = :sectorName")
    List<sectorEntity> findByName(String sectorName);

//    @Query("insert into select s from sectorEntity s where s.sectorName = :sectorName")
//    void sectorToCompany(String sectorName, String companyName);
}
