package stockExchange.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import stockExchange.entities.companyStockExchangeMap;

public interface CompanyStockexchangemaprepo extends JpaRepository<companyStockExchangeMap,Long> {
}
