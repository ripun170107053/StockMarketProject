package stockExchange.services;

import com.project.ripunjoy.entities.companyEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockExchange.dao.StockExchangeRepository;
import stockExchange.entities.StockExchangeEntity;
import stockExchange.models.stockExchangeModel;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    @Transactional
    public StockExchangeEntity findByName(String x)
    {
        StockExchangeEntity ans= sr.findByName(x);
        return ans;
    }

    @Transactional
    public void updateStockExchange(StockExchangeEntity stockExchangeDto)
    {
        if(sr.getById(stockExchangeDto.getId())!=null)
        {
            sr.save(stockExchangeDto);
        }
    }

    @Transactional
    public void addCompanyToStockExchange(String stockExchangeName, String company) throws SQLException {
        if(sr.findByName(stockExchangeName) !=null)
        {
            String url=System.getenv("SPRING_DATASOURCE_URL");

            Connection connect = DriverManager.getConnection(url,"root","root");
            PreparedStatement stmt = connect.prepareStatement("Insert into com_to_se(company_name, stockexc_name) values (?,?)");
            //stmt.setLong(1,1);
            stmt.setString(1,company);
            stmt.setString(2,stockExchangeName);
            stmt.executeUpdate();
        }

    }
}
