package stockExchange.services;

import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.entities.sectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockExchange.dao.sectorRepository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class sectorService
{

    @Autowired
    sectorRepository str;
    public Object getAllSectors()
    {
        return str.findAll();
    }

    @Transactional
    public Optional<sectorEntity> getSectorById(Long id)
    {
        return str.findById(id);
    }
    @Transactional
    public void addSector(sectorEntity sectorDto)
    {
        str.save(sectorDto);
    }
    @Transactional
    public void updateSector(sectorEntity sectorDto)
    {
        if(getSectorById(sectorDto.getId())!=null)
        {
            str.save(sectorDto);
        }
        return;
    }

    @Transactional
    public void deleteById(Long id)
    {
        if(getSectorById(id)!=null)
        {
            str.deleteById(id);
        }
    }
    @Transactional
    public void addCompanyToSector(String sectorName, String companyName) throws SQLException {
        List<sectorEntity>sectors= str.findByName(sectorName);
        System.out.println("list of sectorentity xd: " +sectors);
        sectorEntity sector= sectors.get(0);
        String url=System.getenv("SPRING_DATASOURCE_URL");

        Connection connect = DriverManager.getConnection(url,"root","root");
        PreparedStatement stmt = connect.prepareStatement("Insert into sector_company(sector_name, company_name) values (?,?)");
        //stmt.setLong(1,1);
        stmt.setString(1,sectorName);
        stmt.setString(2,companyName);
        stmt.executeUpdate();

    }
}
