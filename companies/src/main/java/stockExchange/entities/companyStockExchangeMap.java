package stockExchange.entities;

import com.project.ripunjoy.entities.companyEntity;

import javax.persistence.*;

@Entity
@Table(name="company_stock_exchange_map")
public class companyStockExchangeMap
{
    public companyStockExchangeMap()
    {

    }
    @Id
    @GeneratedValue
    private long id;
    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        CompanyCode = companyCode;
    }

    private String CompanyCode;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private companyEntity company;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private StockExchangeEntity stockexchange;

//    public companyEntity getCompany() {
//        return company;
//    }
//
//    public void setCompany(companyEntity company) {
//        this.company = company;
//    }
//
//    public StockExchangeEntity getStockexchange() {
//        return stockexchange;
//    }
//
//    public void setStockexchange(StockExchangeEntity stockexchange) {
//        this.stockexchange = stockexchange;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
