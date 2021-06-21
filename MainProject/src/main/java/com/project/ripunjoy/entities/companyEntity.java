package com.project.ripunjoy.entities;

import stockExchange.entities.companyStockExchangeMap;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="company")
public class companyEntity implements Serializable {
    @Id @GeneratedValue
    public Long id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="turnover")
    private String turnover;
    @Column(name="ceo")
    private String ceo;
    @Column(name="stock_exchange")
    private String stockExchange;
    @Column(name="board_director")
    private String boardDirector;
    @Column(name="sector")
    private String sector;
    @Column(name="writeup")
    private String writeup;
    @Column(name="company_code")
    private String companyCode;

//    @OneToMany(targetEntity = companyStockExchangeMap.class)
//    private List<companyStockExchangeMap> compstockmap; /////////////////////////////////////////////////////
//
//    public List<companyStockExchangeMap> getCompstockmap() {
//        return compstockmap;
//    }
//
//    public void setCompstockmap(List<companyStockExchangeMap> compstockmap) {
//        this.compstockmap = compstockmap;
//    }

    public companyEntity() {
    }
    public companyEntity(String name)
    {
        this.companyName=name;
    }

//    public companyEntity(Long id, String name, List<companyStockExchangeMap> compstockmap) {
//        super();
//        this.id = id;
//        companyName = name;
//        this.compstockmap = compstockmap;
//    }

    public companyEntity(Long id, String name) {
        super();
        this.id = id;
        this.companyName = name;

    }

    public companyEntity(Long id, String companyName, String turnover, String ceo, String stockExchange, String boardDirector, String sector, String writeup, String companyCode) {
        this.id = id;
        this.companyName = companyName;
        this.turnover = turnover;
        this.ceo = ceo;
        this.stockExchange = stockExchange;
        this.boardDirector = boardDirector;
        this.sector = sector;
        this.writeup = writeup;
        this.companyCode = companyCode;
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

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getBoardDirector() {
        return boardDirector;
    }

    public void setBoardDirector(String boardDirector) {
        this.boardDirector = boardDirector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWriteup() {
        return writeup;
    }

    public void setWriteup(String writeup) {
        this.writeup = writeup;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    @Override
    public String toString() {
        return String.format("\nPerson [company_name=%s]", companyName);
    }
}
