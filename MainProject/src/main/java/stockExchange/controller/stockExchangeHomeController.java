package stockExchange.controller;

import com.project.ripunjoy.entities.companyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import stockExchange.dao.StockExchangeRepository;
import stockExchange.entities.StockExchangeEntity;
import stockExchange.models.stockExchangeModel;
import stockExchange.services.StockExchangeService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/stockExchange")
@ComponentScan(basePackages = { "stockExchange"} )
public class stockExchangeHomeController
{

    @Autowired
    StockExchangeRepository sj;

    @Autowired
    StockExchangeService se;

    private static final Logger log = LoggerFactory.getLogger(stockExchangeHomeController.class);

    @CrossOrigin("*")
    @GetMapping("/")
    public List<StockExchangeEntity> home()
    {
        return sj.findAll();
    }
    @GetMapping("/allStockExchanges")
    public List<StockExchangeEntity> getStockExchangesList()
    {
        return sj.findAll();
    }

    @CrossOrigin("*")
    @GetMapping("/allStockExchanges/{id}")
    public StockExchangeEntity findId(@PathVariable String id)
    {
        return se.findByName(id);
    }

    @GetMapping("/findId/{id}")
    public Optional<StockExchangeEntity> findId(@PathVariable Long id)
    {
        return sj.findById(id);
    }
    @PostMapping("/add")
    public String addNewStockExchange(@RequestBody stockExchangeModel stockExchange) {

        se.addNewMarkets(stockExchange);

        return "New Stock Exchange added successfully";
    }

    //get companies for this particular stock exchange
    @GetMapping("/findCompaniesListedIn/{x}")
    public List<companyEntity> findCompaniesListedIn(@PathVariable String x)
    {
        return se.getCompaniesListedOn(x);
    }


//    getCompaniesList



}
