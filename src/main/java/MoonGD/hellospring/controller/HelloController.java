package MoonGD.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String getHelloTemplates (Model model) {
        model.addAttribute("studyStartDate", "2023.12.28 (Thr)");

        return "hello";
    }

    @GetMapping("hello-MVC")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);

        return "hello-mvc";
    }

}
