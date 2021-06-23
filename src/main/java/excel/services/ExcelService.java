package excel.services;

import java.io.*;

import com.google.gson.Gson;
import excel.dao.ExcelRepository;
import kotlin.Pair;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Service
@Transactional
public class ExcelService
{

    @Autowired
    ExcelRepository er;

    List<Integer> companyCode= new ArrayList<>();
    List<String> stockExchange = new ArrayList<>();
    List<Double> currentPrice = new ArrayList<>();
    List<Date> date = new ArrayList<>();
    List<Time> time = new ArrayList<>();
    List<Object> ls = new ArrayList<>() ;
    HashMap<String,List<Double>> xyza= new HashMap<>();

    public void uploadExcel(MultipartFile file) throws IOException, ParseException, SQLException
    {
        //String url = "jdbc:mysql://localhost:3306/StockMarketCharting";
        String url=System.getenv("SPRING_DATASOURCE_URL");

        Connection connect = DriverManager.getConnection(url,"root","root");
        // File file = new File("C:\\Users\\Lenovo User\\Desktop\\ripunjoy\\companies\\sample_stock_data.xlsx");   //creating a new file instance
        File filez = multipartFileToFile(file);
        FileInputStream fis = new FileInputStream(filez);   //obtaining bytes from the file
        ls.clear();
//creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        int hc = 0;
        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
            while (cellIterator.hasNext()) {
                hc++;

                Cell cell = cellIterator.next();
                if (cell.getCellType() == null) break;
                //System.out.println(cell.getCellType());
                ls.add(cell);


//                }
            }
        }

        System.out.println(ls);
        for (hc = 5; hc<ls.size(); hc++)
        {
                    if(ls.get(hc)==null) break;
                    if(hc%5==0)
                    {
                        String z= ls.get(hc).toString();
                        //System.out.println(z);
                        z=z.substring(0,z.length()-2);
                        int x= Integer.parseInt(z);
                        //System.out.println(ls.get(hc).getClass());
                        companyCode.add(x);
                    }
                    if(hc%5==1)
                    {
                        //System.out.println(ls.get(hc));
                        stockExchange.add(ls.get(hc).toString());
                    }
                    if(hc%5==2)
                    {
                       // System.out.println(ls.get(hc));
                        currentPrice.add(Double.parseDouble(ls.get(hc).toString()));
                    }
                    if(hc%5==3)
                    {
                        String d=ls.get(hc).toString();
                        String dd="";
                        dd+=d.charAt(7);
                        dd+=d.charAt(8);
                        dd+=d.charAt(9);
                        dd+=d.charAt(10);
                        dd+='-';
                        String mon ="";
                        mon+=d.charAt(3) ;
                        mon+=d.charAt(4);
                        mon+=d.charAt(5);
//                        dd+=d.charAt(3);
//                        dd+=d.charAt(3);
//                        dd+=d.charAt(5);
                        dd+= month(mon);
                        dd+='-';
                        dd+=d.charAt(0);
                        dd+=d.charAt(1);
                        //System.out.println(dd);
                        date.add(Date.valueOf(dd));
                    }
                    if(hc%5==4)
                    {
                        String d=ls.get(hc).toString();

                        d=d.substring(2);
                       LocalTime t= LocalTime.parse(d);
                        Time tt=Time.valueOf(t);
                        //System.out.println(d);
                        time.add(tt);
                    }
        }
        System.out.println(companyCode);
        System.out.println(stockExchange);
        System.out.println(currentPrice);
        System.out.println(date);
        System.out.println(time);



        for(int j=0;j<companyCode.size();j++)
        {

            //System.out.println(row);

            PreparedStatement st = connect.prepareStatement(
                    "INSERT INTO stock_price_entity(company_code,current_price,date,stock_exchange,time)" + " values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,companyCode.get(j) );
            st.setDouble(2,currentPrice.get(j));
            st.setDate(3, date.get(j));
            st.setString(4, stockExchange.get(j));
            st.setTime(5,time.get(j));
            st.executeUpdate();

           // st.setString

        }
    }

    private String month(String mon)
    {
        if(mon.equals("Jan")) return "01";
        if(mon.equals("Feb")) return "02";
        if(mon.equals("Mar")) return "03";
        if(mon.equals("Apr")) return "04";
        if(mon.equals("May")) return "05";
        if(mon.equals("Jun")) return "06";
        if(mon.equals("Jul")) return "07";
        if(mon.equals("Aug")) return "08";
        if(mon.equals("Sep")) return "09";
        if(mon.equals("Oct")) return "10";
        if(mon.equals("Nov")) return "11";
        if(mon.equals("Dec")) return "12";
        else return "Invalid";

    }

    private void numhand(int hc, Cell cell)
    {
        if(hc%5==3)
        {
            ls.add(cell.getDateCellValue());
        }
        else
        {
            ls.add(cell.getNumericCellValue());
        }
    }

    private File multipartFileToFile(MultipartFile file) throws IOException {
        File convFile = new File("src/main/resources/targetFile2.tmp");
        try (OutputStream os = new FileOutputStream(convFile)) {
            os.write(file.getBytes());
        }
        return convFile;
    }

    public Object exceltoChart() throws SQLException {
        xyza.clear();
        List<String>z = new ArrayList<>();
        List<String>zz = new ArrayList<>();
        //make a object
        //where key is company name
        //value is a 2d array of stock price vs time , for this company

        PreparedStatement ps = null;
        ResultSet rs = null;
        HashMap<Integer,String> xyz = new HashMap<>();
        String url=System.getenv("SPRING_DATASOURCE_URL");

        Connection connect = DriverManager.getConnection(url,"root","root");
        String Query = "select * FROM company ";
        ps = connect.prepareStatement(Query);
        rs = ps.executeQuery();

        //company code to company name mapping
        if(rs!=null)
        {
            while(rs.next())
            {
                xyz.put(rs.getInt("company_code"),rs.getString("company_name"));
            }
        }
        Pair<Double,Time> pd;
        Iterator<Map.Entry<Integer, String>> it = xyz.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<Integer, String> set =  it.next();
            Integer cc=set.getKey();
            //System.out.println(cc + "->");
            for(int ii=0;ii<companyCode.size();ii++)
            {
                //System.out.println(companyCode.get(ii));
                if(Integer.valueOf(companyCode.get(ii)).equals(Integer.valueOf(cc)))
                {
                    // System.out.println(xyz.get(companyCode.get(ii)));  amazon, apple
                    Integer curr= Integer.valueOf(companyCode.get(ii));
                    Integer keyz= Integer.valueOf(cc);

//                    if(xyza.containsKey(xyz.get(companyCode.get(ii))))
//                    {
//                        //System.out.println("y");
//                        List<Double>p=xyza.get(xyz.get(companyCode.get(ii)));
//                        for(int jj=0;jj<currentPrice.size();jj++)
//                        {
//                            if(Integer.valueOf(companyCode.get(jj)).equals(Integer.valueOf(cc)))
//                            {
//                                p.add(currentPrice.get(jj));
//                            }
//                        }
//                        xyza.put(xyz.get(companyCode.get(ii)),p);
//                    }
                    if(1>0)
                    {
                        List<Double>p=new ArrayList<>();
                        for(int jj=0;jj<currentPrice.size();jj++)
                        {
                            if(Integer.valueOf(companyCode.get(jj)).equals(Integer.valueOf(cc)))
                            {
                                p.add(currentPrice.get(jj));
                            }
                        }
                        xyza.put(xyz.get(companyCode.get(ii)),p);

                    }
                }
            }
            // System.out.println(set.getKey() + " = " + set.getValue());
        }



        Gson g = new Gson();
        String json = g.toJson(xyza);
        return json;
        //System.out.println(json);
    }

}