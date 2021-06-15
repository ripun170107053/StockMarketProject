package ipo.models;

import javax.persistence.*;
import java.util.Date;


public class ipoDetailsModel   //each company has their own IPO. and each IPO will be listed in given stock exchanges
{

    private Long id;


    private String companyName;


    private String stockExchange;


    private Double pricePerShare;


    private Long totalNumberOfShares;


    private Date openDateTime;


    private String remarks;

    public ipoDetailsModel() {
    }

    public ipoDetailsModel(Long id, String companyName, String stockExchange, Double pricePerShare, Long totalNumberOfShares, Date openDateTime, String remarks) {
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
