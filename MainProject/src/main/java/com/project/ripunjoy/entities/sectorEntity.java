package com.project.ripunjoy.entities;

import javax.persistence.*;

@Entity
@Table(name="sector")
public class sectorEntity
{
    @Id @GeneratedValue @Column(name="id")
    private Long id;
    @Column(name="sector_name")
    private String sectorName;
    @Column(name="brief")
    private String brief;

    public sectorEntity() {
    }

    public sectorEntity(Long id, String sectorName, String brief) {
        this.id = id;
        this.sectorName = sectorName;
        this.brief = brief;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
