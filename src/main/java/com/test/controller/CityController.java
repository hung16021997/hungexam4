package com.test.controller;

import com.test.model.City;
import com.test.model.Country;
import com.test.service.CityService;
import com.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam; //

@Controller
//@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityServiceImpl;

    @Autowired
    private CountryService countryServiceImpl;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryServiceImpl.findAll();
    }

    @GetMapping("cities")
    public ModelAndView showListCities() {
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cityServiceImpl.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute(value = "city") City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/city/create");
            modelAndView.addObject("message1", "Invalid information, please re-input");
            return modelAndView;
        }
        cityServiceImpl.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city has been created successfully!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        City city = cityServiceImpl.findById(id);
        ModelAndView modelAndView;
        if (city != null) {
            modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
        } else {
            modelAndView = new ModelAndView(("/error404"));

        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("message1", "Invalid information, please re-input");
            return modelAndView;
        }
        cityServiceImpl.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Updated city info successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        City city = cityServiceImpl.findById(id);
        ModelAndView modelAndView;
        if (city != null) {
            modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city);
        } else {
            modelAndView = new ModelAndView("/error404");
        }
        return modelAndView;
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city) {
        cityServiceImpl.remove(city.getId());
        return "redirect:cities";
    }

    @GetMapping("/detail/{id}")
    private ModelAndView detailCity(@PathVariable Long id) {
        City detailCity = cityServiceImpl.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/detail");
        modelAndView.addObject("city", detailCity);
        return modelAndView;
    }
}


