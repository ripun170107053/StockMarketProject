package stockExchange.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="stock_exchange_entity")
public class StockExchangeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="stock_exchange")
    private String stockExchange;
    @Column(name="brief")
    private String brief;
    @Column(name="contact_address")
    private String contactAddress;
    @Column(name="remarks")
    private String remarks;

    public StockExchangeEntity(){}

    private StockExchangeEntity(String stockExchange, String brief, String contactAddress, String remarks) {
        this.stockExchange = stockExchange;
        this.brief = brief;
        this.contactAddress = contactAddress;
        this.remarks = remarks;
    }

//    @OneToMany(targetEntity = companyStockExchangeMap.class)
//    private List<companyStockExchangeMap> compstockmap;
//
//    public List<companyStockExchangeMap> getCompstockmap() {
//        return compstockmap;
//    }
//
//    public void setCompstockmap(List<companyStockExchangeMap> compstockmap) {
//        this.compstockmap = compstockmap;
//    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}