package ipo.controller;

import ipo.dao.IpoRepository;
import ipo.entities.ipoDetailsEntity;
import ipo.models.ipoDetailsModel;
import ipo.services.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/IPO")
public class ipoController
{
    @Autowired
    IpoRepository ir;

    @Autowired
    IpoService is;

    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/")
    public String home()
    {
        return "IPO home";
    }

    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @GetMapping("/allIPO")
    public List<ipoDetailsEntity> allIPOsByChronologicalOrder()
    {
        return is.sortIPO();
        //return "Successfully listed all IPOs sorted in ascending order of their opening date (nearest IPO on the top";
    }

    @CrossOrigin(origins ="https://reactphase3ripun.herokuapp.com")
    @PostMapping("/addIPO")
    public String addIPO(@RequestBody ipoDetailsModel ipo)
    {
        is.addIPO(ipo);
        return "Successfully added IPO";
    }
    @GetMapping("/{id}")
    public Optional<ipoDetailsEntity> getIpoById(@PathVariable Long id){
        return ir.findById(id);
    }
    @PutMapping("/{id}")
    public void editIpoByID(@RequestBody ipoDetailsEntity ipoDto, @PathVariable Long id){
        is.updateIpo(ipoDto,id);
    }




}
