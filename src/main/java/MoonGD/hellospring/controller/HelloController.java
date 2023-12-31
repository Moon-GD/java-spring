package MoonGD.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-api-string")
    @ResponseBody
    public String helloApiString(@RequestParam("name") String name) {
        return "hello-" + name;
    }

    static class NameManager {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("hello-api-object")
    @ResponseBody
    public NameManager helloApiObject(@RequestParam("name") String name) {
        NameManager nameManager = new NameManager();
        nameManager.setName(name);

        return nameManager;
    }
}
