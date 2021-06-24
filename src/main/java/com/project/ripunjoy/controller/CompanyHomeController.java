package com.project.ripunjoy.controller;

import com.project.ripunjoy.dao.CompanyRepository;
import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import com.project.ripunjoy.services.companyService;
import excel.entities.stockPriceEntity;
import excel.models.stockPriceModel;
import ipo.dao.IpoRepository;
import ipo.entities.ipoDetailsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    IpoRepository ir;

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
    @PutMapping("/update")
    public String updateCompany(@RequestBody companyModel company) {
        System.out.println(String.format("Successfully updated %s",company.getCompanyName()));
         cs.updateThisCompany(company);
        if(!cr.findById(company.getId()).isEmpty())return String.format("Successfully updated company= %s with given id=%o",company.getCompanyName(),company.getId());
        else return "Company with given ID not found";
    }

    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id)
    {
        if(cr.findById(id)==null)
        {
            return "Company with given ID not found";
        }
        else
        {

            cr.deleteById(id);
            return "Successfully deleted this company";
        }

    }
    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/{id}/ipos")
    public Optional<ipoDetailsEntity> getCompanyIpoDetails(@PathVariable String id)
    {
        Optional<companyEntity> company = cr.findByName(id);
        //System.out.println("company"+company);
        if(company !=null)
        {
            System.out.println("ipotoc"+ id);
           return cr.ipoToCompany(id);
        }
        else return null;

    }
    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/{id}/x")
    public Optional<companyEntity> getC(@PathVariable String id)
    {
        return cr.findByName(id);

    }
    @GetMapping(path = "/{name}/stockPrices")
    public List<stockPriceEntity> getStockPrices(@PathVariable String name){
        List<stockPriceEntity> stockPriceE = cs.getStocksForThisCompany(name);
        return stockPriceE;
    }

    @PostMapping(path = "/{companyName}/ipos")
    public void addIpoToCompany(@PathVariable String companyName, @RequestBody ipoDetailsEntity ipo)
    {
        Optional<companyEntity> ce = cr.findByName(companyName);
        companyEntity cez = ce.get();
        if(cez!=null)
        {
            ir.saveAndFlush(ipo);
        }

    }




}
