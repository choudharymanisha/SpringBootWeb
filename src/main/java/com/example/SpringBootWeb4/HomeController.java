package com.example.SpringBootWeb4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        System.out.println("home method called ");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(
            @RequestParam(required = false) Integer num1,
            @RequestParam(required = false) Integer num2,
            ModelAndView mv ) {

        if (num1 != null && num2 != null) {  // Check if both numbers are provided
            int result = num1 + num2;
          mv.addObject("result",result);
          mv.setViewName("result");
            System.out.println(result);
        } else {
            mv.addObject("result", "Invalid input. Please enter valid numbers.");
        }

        return mv ;
    }
}
