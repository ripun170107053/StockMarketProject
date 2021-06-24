package ipo.services;

import com.project.ripunjoy.entities.companyEntity;
import ipo.dao.IpoRepository;
import ipo.entities.ipoDetailsEntity;
import ipo.models.ipoDetailsModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockExchange.dao.StockExchangeRepository;
import stockExchange.entities.StockExchangeEntity;
import stockExchange.models.stockExchangeModel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IpoService
{
    @Autowired
    IpoRepository ir;

    @Transactional
    public List<ipoDetailsEntity> sortIPO()
    {
         List<ipoDetailsEntity> ans= ir.sortIPO();
         return ans;
    }

    @Transactional
    public void addIPO(ipoDetailsModel ipo)
    {
        ipoDetailsEntity ipo_new = new ipoDetailsEntity();
        BeanUtils.copyProperties(ipo,ipo_new);
        ir.saveAndFlush(ipo_new);
    }
    @Transactional
    public Object getIpoById(Long id)
    {
        Optional<ipoDetailsEntity> im = ir.findById(id);
        if(!im.isPresent()) return null;
        else return im;
    }
    @Transactional
    public void updateIpo(ipoDetailsEntity ipoDto, Long id)
    {
        if(id==null) {
            return;
        }
        ipoDto.setId(id);
        ir.save(ipoDto);
    }
    //company.company_name is tied to ipoService.company_name
    //ipoService.stock_exchange is tied to stock_exchange_entity.stock_exchange





}
