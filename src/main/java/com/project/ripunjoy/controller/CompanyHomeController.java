package com.project.ripunjoy.controller;

import com.project.ripunjoy.dao.CompanyRepository;
import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import com.project.ripunjoy.services.companyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/companies")
public class CompanyHomeController
{


    @Autowired
    CompanyRepository cr;
    @Autowired
    companyService cs;

    private static final Logger log = LoggerFactory.getLogger(CompanyHomeController.class);
    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/")
    List<companyEntity> viewAll()
    {
        return cr.findAll();
    }
    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/findById/{id}")
    public Optional<companyEntity> getCompanyDetailsById(@PathVariable(value = "id") Long bookId)
    {
        return cr.findById(bookId);
    }
    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/getMatchingCompanies/{x}")
    public List<companyEntity> getMatchingCompanies(@PathVariable(value = "x") String p) {
        return cr.findByPattern(p);
    }
//    @GetMapping("/getMatchingCompanies/{x}/ipo")
//    public String getMatchingCompaniesIPO(@PathVariable(value = "x") String p)
//    {
//        return cs.getIPO(p);
//    }

    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @RequestMapping(value = "/add",method=RequestMethod.POST, headers = "Accept=application/json"  )
    public String addNewCompany(@RequestBody companyEntity company) {
        cs.addNewCompany(company);
        return "Successfully added company";
    }
    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @PostMapping("/update")
    public String updateCompany(@RequestBody companyModel company) {
        System.out.println(String.format("Successfully updated %s",company.getCompanyName()));
         cs.updateThisCompany(company);
        if(!cr.findById(company.getId()).isEmpty())return String.format("Successfully updated company= %s with given id=%o",company.getCompanyName(),company.getId());
        else return "Company with given ID not found";
    }
//    @GetMapping("/{x}/ipo")
//    public getIPOofThisCompany

}
    //insert into company values (5,"the2time","Billi", 52,"Microsoft",18,"NSE",2014,"secondpost")