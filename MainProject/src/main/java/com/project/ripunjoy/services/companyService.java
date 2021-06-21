package com.project.ripunjoy.services;

import com.project.ripunjoy.dao.CompanyRepository;
import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class companyService
{
    @Autowired
    CompanyRepository cr;

    @Transactional
    public List<companyModel> findByPattern(String companyName) {
        List<companyModel> companyList = new ArrayList<>();
        List<companyEntity> companies = cr.findByPattern(companyName);
        if (companies.isEmpty()==false) {
            companies.forEach(companyItem -> {
                companyModel cp = new companyModel();
                BeanUtils.copyProperties(companyItem, cp);
                companyList.add(cp);
            });
        }
        return companyList;
    }

    @Transactional
    public void addNewCompany(companyEntity cm)
    {
        cr.save(cm);
        //return ResponseEntity.created("").build();
    }

    public String getIPO(String p) 
    {
        return "xyz";
    }

    @Transactional
    public void updateThisCompany(companyModel company)
    {
        Optional<companyEntity> toUpdate = cr.findById(company.getId());
        if(toUpdate.isPresent())
        {
            companyEntity temp=toUpdate.get();

            if(company.getTurnover()!=null)
            {
                temp.setTurnover(company.getTurnover());
            }


            if(company.getCompanyName()!=null)
                temp.setCompanyName(company.getCompanyName());

            if(company.getCeo()!=null)
                temp.setCeo(company.getCeo());

            if(company.getBoardDirector()!=null)
                temp.setBoardDirector(company.getBoardDirector());

            if(company.getWriteup()!=null)
                temp.setWriteup(company.getWriteup());

            if(company.getCompanyCode()!=null)
                temp.setCompanyCode(company.getCompanyCode());
            cr.saveAndFlush(temp);

        }


    }


}
