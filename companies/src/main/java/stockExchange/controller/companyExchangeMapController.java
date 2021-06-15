//package stockExchange.controller;
//
//import com.project.ripunjoy.jpa.companyJPA;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import stockExchange.jpa.CompanyStockexchangemaprepo;
//
//public class companyExchangeMapController
//{
//    @Autowired
//    CompanyStockexchangemaprepo cstkmaprep;
//    @Autowired
//    companyJPA cmprep;
//    @Autowired
//    Companystockexchangemaprepo2 cstmap;
//
//    StockExchangerepository stkrep;
//    @RequestMapping(value="/mapcompanycode/{companyname}/{exchangename}/{companycode}", method= RequestMethod.POST)
//    public String mapcode(@PathVariable String companyname, @PathVariable String exchangename , @PathVariable String companycode) {
//
//        System.out.println(companyname +"params in rest controller before retlist call");
//        cstmap.retlist(companyname, exchangename, companycode);
//
//
//
//        return  companyname ;
//        //return companyname;
//    }
//
//
//
//    @RequestMapping(value="/getcompanycode/{companyid}", method=RequestMethod.GET)
//    public String getcode(@PathVariable String companyid) {
//
//
//        return  cstmap.readlist(companyid);
//
//    }
//}
