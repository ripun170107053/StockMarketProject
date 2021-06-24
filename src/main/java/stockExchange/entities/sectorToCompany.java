package stockExchange.entities;

import io.micrometer.core.annotation.Counted;

import javax.persistence.*;

@Entity
@Table(name="sector_company")
public class sectorToCompany
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="sector_name")
    private String sectorName;
    @Column(name="company_name")
    private String companyName;

    public sectorToCompany() {
    }

    public sectorToCompany(Long id,String sectorName, String companyName) {
        this.id = id;
        this.sectorName = sectorName;
        this.companyName = companyName;
    }

    public String getSectorName() {
        return sectorName;
    }


    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
