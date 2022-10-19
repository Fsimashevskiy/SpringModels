package com.app.crud.controller;

import com.app.crud.model.Car;
import com.app.crud.model.Phone;
import com.app.crud.model.SearchForm;
import com.app.crud.model.User;
import com.app.crud.service.CarService;
import com.app.crud.service.PhoneService;
import com.app.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Validated
@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    PhoneService phoneService;

    @Autowired
    CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("searchForm", new SearchForm());
        return "user";
    }

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public String getUserById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        User user = userService.findUserById(searchForm.getId());
        if(user==null){
            return "redirect:/users";
        }
        model.addAttribute("user", user );
        return "searchUser";
    }

    @RequestMapping(value = "/users/efind", method = RequestMethod.GET)
    public String getUserByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        User user = userService.findUserByIdContains(searchForm.getId());
        if(user==null){
            return "redirect:/users";
        }
        model.addAttribute("user", user );
        return "searchUser";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String addUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public String phones(Model model) {
        model.addAttribute("phones", phoneService.findAllPhones());
        model.addAttribute("searchForm", new SearchForm());
        return "phone";
    }

    @RequestMapping(value = "/phones/find", method = RequestMethod.GET)
    public String getPhoneById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Phone phone = phoneService.findPhoneById(searchForm.getId());
        if(phone==null){
            return "redirect:/phones";
        }
        model.addAttribute("phone", phone );
        return "searchPhone";
    }

    @RequestMapping(value = "/phones/efind", method = RequestMethod.GET)
    public String getPhoneByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Phone phone = phoneService.findPhoneByIdContains(searchForm.getId());
        if(phone==null){
            return "redirect:/phones";
        }
        model.addAttribute("phone", phone );
        return "searchPhone";
    }

    @RequestMapping(value = "/phones/add", method = RequestMethod.GET)
    public String addPhonePage(Model model) {
        Phone phone = new Phone();
        model.addAttribute("phone", phone);
        model.addAttribute("users", userService.findAllUsers());
        return "addPhone";
    }

    @RequestMapping(value = "/phones/add", method = RequestMethod.POST)
    public String addPhone(Phone phone, BindingResult result) {
        if (result.hasErrors()) {
            return "addPhone";
        }
        phoneService.save(phone);
        return "redirect:/phones";
    }

    @RequestMapping(value = "/phones/delete/{id}", method = RequestMethod.POST)
    public String deletePhone(@PathVariable("id") int id) {
        phoneService.delete(id);
        return "redirect:/phones";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String cars(Model model) {
        model.addAttribute("cars", carService.findAllCars());
        model.addAttribute("searchForm", new SearchForm());
        return "car";
    }

    @RequestMapping(value = "/cars/find", method = RequestMethod.GET)
    public String getCarById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Car car = carService.findCarById(searchForm.getId());
        if(car==null){
            return "redirect:/cars";
        }
        model.addAttribute("car", car );
        return "searchCar";
    }

    @RequestMapping(value = "/cars/efind", method = RequestMethod.GET)
    public String getCarByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Car car = carService.findCarByIdContains(searchForm.getId());
        if(car==null){
            return "redirect:/cars";
        }
        model.addAttribute("car", car );
        return "searchCar";
    }
    @RequestMapping(value = "/cars/add", method = RequestMethod.GET)
    public String addCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("users", userService.findAllUsers());
        return "addCar";
    }

    @RequestMapping(value = "/cars/add", method = RequestMethod.POST)
    public String addCar(Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "addCar";
        }
        carService.save(car);
        return "redirect:/cars";
    }

    @RequestMapping(value = "/cars/delete/{id}", method = RequestMethod.POST)
    public String deleteCar(@PathVariable("id") int id) {
        carService.delete(id);
        return "redirect:/cars";
    }

}
