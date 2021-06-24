package stockExchange.entities;

import javax.persistence.*;

@Entity
@Table(name="com_to_se")
public class comToSe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="company_name")
    private String companyName;
    @Column(name="stockExc_name")
    private String stockExcName;

    public comToSe() {
    }

    public comToSe(Long id, String companyName, String stockExcName) {
        this.id = id;
        this.companyName = companyName;
        this.stockExcName = stockExcName;
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

    public String getStockExcName() {
        return stockExcName;
    }

    public void setStockExcName(String stockExcName) {
        this.stockExcName = stockExcName;
    }
}
