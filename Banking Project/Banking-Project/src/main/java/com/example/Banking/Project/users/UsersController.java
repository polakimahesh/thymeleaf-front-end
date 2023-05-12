package com.example.Banking.Project.users;


import org.hibernate.validator.constraints.ModCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;


    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<Users> users=usersService.getAllUsers();
        model.addAttribute("alluserlist",users);
        model.addAttribute("template","users.html");
        model.addAttribute("style","users.css");
        model.addAttribute("title","Users");
        return "component";
    }

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("template","home.html");
        model.addAttribute("title","Home");
        model.addAttribute("style","home.css");
        return "component";
    }
    @GetMapping("/aboutUs")
    public String getAboutUs(Model model){
        model.addAttribute("template","about.html");
        model.addAttribute("title","About Us");
        model.addAttribute("style","about.css");
        return "component";
    }
    @GetMapping("/users/{id}")
    public String getSingleUser( Model model,@PathVariable("id") int id){

        model.addAttribute("singleUser",usersService.getSingleUser(id));
        model.addAttribute("template","singleUser.html");
        return "component" ;

    }
    @GetMapping("/register-user")
    public String addNewUser(Model model){
        Users users = new Users();
        model.addAttribute("user",users);
        model.addAttribute("template","newUser.html");
        model.addAttribute("title","Register-User");
        return "component";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("users") Users users) {
        usersService.save(users);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public  String deleteUser( @PathVariable int id){
        usersService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/register-user/{id}")
    public String updateUser(Model model,@PathVariable("id") int id){
        Users users = usersService.getSingleUser(id);
        model.addAttribute("user",users);
        model.addAttribute("template","newUser.html");
        model.addAttribute("title","Update-User");
        return "component";
    }

}
