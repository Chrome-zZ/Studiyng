package spring.study.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.plaf.SpinnerUI;

@Controller
public class SecondController {

     @GetMapping("/exit")
    public String exit() {
         return "second/exit";
     }
}
