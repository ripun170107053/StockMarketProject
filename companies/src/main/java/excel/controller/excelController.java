package excel.controller;

import com.project.ripunjoy.dao.CompanyRepository;
import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import com.project.ripunjoy.services.companyService;
import excel.dao.ExcelRepository;
import excel.models.stockPriceModel;
import excel.services.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/excel")
public class excelController
{
    @Autowired
    ExcelService es;
    @Autowired
    ExcelRepository er;
    @PostMapping("/uploadExcel")
    public String uploadExcel(@RequestParam("file") MultipartFile file) throws IOException
    {
        es.uploadExcel(file);
        return "Excel file uploaded successfully";
    }

}

