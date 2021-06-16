package excel.controller;

import excel.dao.ExcelRepository;

import excel.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

@RestController
@RequestMapping("/excel")
public class excelController
{
    @Autowired
    ExcelService es;
    @Autowired
    ExcelRepository er;








    @PostMapping("/uploadExcel")
    public String uploadExcel(@RequestParam("file") MultipartFile file) throws IOException, ParseException, SQLException
    {

        es.uploadExcel(file);
        return "Excel file uploaded successfully";
    }

}

