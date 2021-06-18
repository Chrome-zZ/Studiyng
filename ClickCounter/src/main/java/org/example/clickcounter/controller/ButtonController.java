package org.example.clickcounter.controller;

import org.example.clickcounter.model.Button;
import org.example.clickcounter.repository.ButtonRepo;
import org.example.clickcounter.response.ClickResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class ButtonController {

    private final ButtonRepo buttonRepo;

    public ButtonController(ButtonRepo buttonRepo) {
        this.buttonRepo = buttonRepo;
    }

    @GetMapping("/")
    public Integer getCount() {
        return buttonRepo.getOne(1).getCount();
    }

    @PostMapping("/")
    public ClickResponse click(HttpServletRequest request) {
        int count = Integer.parseInt(request.getParameter("count"));

        Button button = buttonRepo.getOne(1);
        button.setCount(++count);

        ClickResponse response = new ClickResponse();
        response.setCount(++count);
        return response;
    }

}
