package stockExchange.controller;

import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.entities.sectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sector")
@CrossOrigin
public class sectorController
{
    @Autowired
    private stockExchange.services.sectorService sectorService;

    @GetMapping("/sectors")
    public List<sectorEntity> getAllSectors(){
        return (List<sectorEntity>) sectorService.getAllSectors();
    }

    @GetMapping("/{id}")
    public Optional<sectorEntity> getSectorById(@PathVariable Long id)
    {
        return sectorService.getSectorById(id);
    }

    @PostMapping("/add")
    public void addSector(@RequestBody sectorEntity sectorDto){
        sectorService.addSector(sectorDto);
    }

    @PutMapping("/update")
    public void editSector(@RequestBody sectorEntity sectorDto){
        sectorService.updateSector(sectorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSectorById(@PathVariable Long id) {
        sectorService.deleteById(id);
    }

    @PostMapping("/{sectorName}/{companyName}")
    public void addCompanyToSector(@PathVariable String sectorName,@PathVariable String companyName) throws SQLException {
        sectorService.addCompanyToSector(sectorName, companyName);
    }
}
