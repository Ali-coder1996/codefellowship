package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AppUserRepository appUserRepository;


    @GetMapping("/")
    public String homePAge(Principal p,Model m){
        if(p !=null ){
            ApplicationUser applicationUser = appUserRepository.findByUsername(p.getName());
            m.addAttribute("username",applicationUser);
            return "Home";
        }
        return "Home";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/signup")
    public String getSignUpPage(Principal p,Model m){
        return "signup";
    }
    @PostMapping("/signup")
    public String singUp(@RequestParam String password,
                         @RequestParam String username,
                         @RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String dateOfBirth,
                         @RequestParam String bio){
        ApplicationUser applicationUser=new ApplicationUser(encoder.encode(password),username,
                firstName,lastName,dateOfBirth,bio,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXp3DxP80ArpRzsB0XWBG9Ow5GeuefbLrUHw&usqp=CAU");
        appUserRepository.save(applicationUser);
        return "login";
    }
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id, Principal p, Model m){
        if(p != null){
            System.out.println("ali");
            ApplicationUser applicationUser = appUserRepository.findById(id).get();
            m.addAttribute("user", applicationUser);
            return "profile";
        }
        return "/error?message=You%are%not%allow%to%delete%the%user";
    }



}
