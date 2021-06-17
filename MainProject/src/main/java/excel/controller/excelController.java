package excel.controller;

import excel.dao.ExcelRepository;

import excel.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

//    @CrossOrigin(origins ="http://localhost:3000", allowedHeaders = "*")
//    @GetMapping(value="/files")
//    public String testing()
//    {
//        return "Excel files will be shown here";
//    }

    @CrossOrigin(origins ="http://localhost:3002", allowedHeaders = "*")
    @PostMapping(value="/uploadExcel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadExcel(@RequestParam MultipartFile file) throws IOException, ParseException, SQLException
    {

        es.uploadExcel(file);
        return "Excel file uploaded successfully";
    }

}

