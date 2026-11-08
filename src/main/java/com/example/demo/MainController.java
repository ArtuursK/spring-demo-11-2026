package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @PostMapping("/hello")
    public String helloPage(@RequestParam("name") String vards, Model model) {
        //TODO: noskaidrot vai vārds ir sieviešu vai vīriešu dzimtē un izvēlēties atbilstošu uzrunu
        String result = "Sveiki, " + vards + "!";
        System.out.println("Saņemts: " + vards);
        model.addAttribute("result", result);
        return "hello";
    }

}