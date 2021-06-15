package excel.services;

import com.project.ripunjoy.entities.companyEntity;
import ipo.dao.IpoRepository;
import ipo.entities.ipoDetailsEntity;
import ipo.models.ipoDetailsModel;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import stockExchange.dao.StockExchangeRepository;
import stockExchange.entities.StockExchangeEntity;
import stockExchange.models.stockExchangeModel;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExcelService
{

    public void uploadExcel(MultipartFile file)
    {

    }
}
