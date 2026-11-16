package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class MainController {


    @RequestMapping(value = "/abc", method = RequestMethod.GET)
    public String indexPage() {
        System.out.println("Esmu iekšā /abc");
        return "index";
    }


    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @GetMapping("/kalkulators")
    public String getCalc() {
        return "kalkulators";
    }

    @GetMapping("/kalkulators2")
    public String getCalc2() {
        return "kalkulators2";
    }

    @PostMapping("/kalkulators")
    public String postCalc(
            @RequestParam("pirmaisSkaitlis") Double pirmaisSkaitlis,
            @RequestParam("otraisSkaitlis") Double otraisSkaitlis,
            @RequestParam("darbiba") String darbiba,
            Model model) {
        //datu validācija un verifikācija
//        System.out.println(pirmaisSkaitlis);
//        System.out.println(otraisSkaitlis);
//        System.out.println(darbiba);
        System.out.println(LocalDateTime.now() + " Tika izsaukts POST /kalkulators");

        //aprekinat izteiksmes vertibu
        String rezultats = "noklusējuma vērtība";
        switch (darbiba) {
            case "/":
                if(otraisSkaitlis != 0) {
                    rezultats = String.valueOf(pirmaisSkaitlis / otraisSkaitlis);
                } else {
                    rezultats = "Dalīt ar 0 nedrīkst!!!";
                }
                break;
            case "*":
                rezultats = String.valueOf(pirmaisSkaitlis * otraisSkaitlis);
                break;
            case "+":
                rezultats = String.valueOf(pirmaisSkaitlis + otraisSkaitlis);
                break;
            case "-":
                rezultats = String.valueOf(pirmaisSkaitlis - otraisSkaitlis);
                break;
            default:
                rezultats = "Rezultātu aprēķināt neizdevās";
                break;
        }
        model.addAttribute("result", rezultats);
        return "kalkulators2";
    }

}