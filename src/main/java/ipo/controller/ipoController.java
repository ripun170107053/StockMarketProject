package ipo.controller;

import ipo.dao.IpoRepository;
import ipo.entities.ipoDetailsEntity;
import ipo.models.ipoDetailsModel;
import ipo.services.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/IPO")
public class ipoController
{
    @Autowired
    IpoRepository ir;

    @Autowired
    IpoService is;

    @CrossOrigin("*")
    @GetMapping("/")
    public String home()
    {
        return "IPO home";
    }

    @CrossOrigin("*")
    @GetMapping("/allIPO")
    public List<ipoDetailsEntity> allIPOsByChronologicalOrder()
    {
        return is.sortIPO();
        //return "Successfully listed all IPOs sorted in ascending order of their opening date (nearest IPO on the top";
    }

    @CrossOrigin("*")
    @PostMapping("/addIPO")
    public String addIPO(@RequestBody ipoDetailsModel ipo)
    {
        is.addIPO(ipo);
        return "Successfully added IPO";
    }



}
