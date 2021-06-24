package stockExchange.controller;


import excel.dao.ExcelRepository;
import excel.entities.stockPriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/stockPrice")
public class stockController
{
    @Autowired
    ExcelRepository er;



    @GetMapping("/all")
    public List<stockPriceEntity> getAllStockPrices()
    {
        return er.findAll();
    }
    @PostMapping("/add")
    public void addStockPrice(@RequestBody stockPriceEntity stockPriceDto) throws SQLException {
        String url=System.getenv("SPRING_DATASOURCE_URL");

        Connection connect = DriverManager.getConnection(url,"root","root");
        PreparedStatement stmt = connect.prepareStatement("Insert into stock_price_entity(company_code, stock_exchange, current_price,date,time) " +
                "values (?,?,?,?,?)");
        //stmt.setLong(1,1);
        stmt.setLong(1,stockPriceDto.getCompanyCode());
        stmt.setString(2,stockPriceDto.getStockExchange());
        stmt.setDouble(3,stockPriceDto.getCurrentPrice());
        stmt.setDate(4,  stockPriceDto.getDate());
        stmt.setTime(5,stockPriceDto.getTime());
        stmt.executeUpdate();
        //er.save(stockPriceDto);
    }

    @PutMapping("/update")
    public void updateStockPrice(@RequestBody stockPriceEntity stockPriceDto) throws SQLException {
        String url=System.getenv("SPRING_DATASOURCE_URL");

        Connection connect = DriverManager.getConnection(url,"root","root");
        PreparedStatement stmt = connect.prepareStatement("update stock_price_entity  set " +
                "company_code = ?, " +
                "stock_exchange = ?, " +
                "current_price = ?," +
                "date = ?," +
                "time = ? " +
                "where id= ?");
        //stmt.setLong(1,1);
        stmt.setLong(1,stockPriceDto.getCompanyCode());
        stmt.setString(2,stockPriceDto.getStockExchange());
        stmt.setDouble(3,stockPriceDto.getCurrentPrice());
        stmt.setDate(4, (Date) stockPriceDto.getDate());
        stmt.setTime(5,stockPriceDto.getTime());
        stmt.setLong(6,stockPriceDto.getId());
        stmt.executeUpdate();
    }
    @DeleteMapping("/{id}")
    public void deleteStockPriceById(@PathVariable Long id) {
        er.deleteById(id);
    }
//    @GetMapping(path = "/compareCompany/{from}/{to}/{code}/{stockExchangeName}")
//    public ResponseEntity<?> companyComparison(@PathVariable String from,@PathVariable String to,
//                                               @PathVariable String code,@PathVariable String stockExchangeName)
//    {
//        List<stockPriceEntity> stockPriceDtos = null;
//        try {
//            stockPriceDtos = stockPriceService.getStockPricesForCompanyComparison(from, to, code, stockExchangeName);
//        } catch (ParseException e) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("Invalid Date Format");
//        }
//        return ResponseEntity.ok(stockPriceDtos);
//    }



}
