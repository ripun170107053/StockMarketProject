package ipo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ipo_detail")
public class ipoDetailsEntity   //each company has their own IPO. and each IPO will be listed in given stock exchanges
{
    @Id   @GeneratedValue
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="stock_exchange")
    private String stockExchange;

    @Column(name="price_per_share")
    private Double pricePerShare;

    @Column(name="total_number_of_shares")
    private Long totalNumberOfShares;

    @Column(name="open_date_time")
    private Date openDateTime;

    @Column(name="remarks")
    private String remarks;

    public ipoDetailsEntity() {
    }

    public ipoDetailsEntity(Long id, String companyName, String stockExchange, Double pricePerShare, Long totalNumberOfShares, Date openDateTime, String remarks) {
        this.id = id;
        this.companyName = companyName;
        this.stockExchange = stockExchange;
        this.pricePerShare = pricePerShare;
        this.totalNumberOfShares = totalNumberOfShares;
        this.openDateTime = openDateTime;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public Double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(Double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public Long getTotalNumberOfShares() {
        return totalNumberOfShares;
    }

    public void setTotalNumberOfShares(Long totalNumberOfShares) {
        this.totalNumberOfShares = totalNumberOfShares;
    }

    public Date getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(Date openDateTime) {
        this.openDateTime = openDateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
