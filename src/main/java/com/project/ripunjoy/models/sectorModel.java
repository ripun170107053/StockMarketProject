package com.project.ripunjoy.models;

public class sectorModel
{
    private Long id;
    private String sectorName;
    private String brief;

    public sectorModel() {
    }

    public sectorModel(Long id, String sectorName, String brief) {
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
