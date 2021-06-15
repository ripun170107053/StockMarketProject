package stockExchange.services;

import com.project.ripunjoy.entities.companyEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockExchange.dao.StockExchangeRepository;
import stockExchange.entities.StockExchangeEntity;
import stockExchange.models.stockExchangeModel;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockExchangeService
{
    @Autowired
    StockExchangeRepository sr;

    @Transactional
    public void addNewMarkets(stockExchangeModel stockExchange)
    {
        StockExchangeEntity se_new=new StockExchangeEntity();
        BeanUtils.copyProperties(stockExchange,se_new);
        sr.saveAndFlush(se_new);

    }
    @Transactional
    public List<companyEntity> getCompaniesListedOn(String x)
    {
        List<companyEntity> ans= sr.getCompaniesListedOn(x);
        return ans;
    }



}
