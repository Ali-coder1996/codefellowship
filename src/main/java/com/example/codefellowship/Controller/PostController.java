package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Model.Post;
import com.example.codefellowship.Repository.AppUserRepository;
import com.example.codefellowship.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    AppUserRepository appUserRepository;

//    @GetMapping("/post")
//    public String postPage( Model m) {
//        System.out.println("2");
//        List<Post> post = (List<Post>) postRepository.findAll();
//        m.addAttribute("post",post);
//        return "profile";
//    }
    @PostMapping("/post")
    public RedirectView post(@RequestParam String body , Principal p ){
        System.out.println("1");
        ApplicationUser applicationUser1 = appUserRepository.findByUsername(p.getName());
        Post post =new Post(body,applicationUser1);
        postRepository.save(post);
        return new RedirectView("/myprofile/" + applicationUser1.getId());
    }

}
