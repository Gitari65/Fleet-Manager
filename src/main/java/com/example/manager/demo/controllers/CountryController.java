package com.example.manager.demo.controllers;

import com.example.manager.demo.models.Country;
import com.example.manager.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountry(Model model){

        List<Country> countryList=countryService.getCountries();
        model.addAttribute("countries",countryList);
        return "country";
    }

    @PostMapping("/countries/addNew")
public String addNew(Country country){
        countryService.save(country);
        return "redirect:/countries";
}

   @RequestMapping("/countries/findById")
   @ResponseBody
    public Optional<Country> findByID(@RequestParam  Integer id){
        return countryService.findById(id);

    }
    @RequestMapping ( value = "/countries/update",

    method = {RequestMethod.PUT,RequestMethod.POST})
    public  String update(Country country){
        countryService.save(country);
        return  "redirect:/countries";
    }
    @RequestMapping(value  ="/countries/delete",
            method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(@RequestParam Integer id){
        countryService.delete(id);
        return "redirect:/countries";

    }



}

