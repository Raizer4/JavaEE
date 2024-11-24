package spring.http.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import spring.dto.UserReadDto;

@Controller
@SessionAttributes({"user"})
public class GreetingController {

    @GetMapping("/hello")
    public String hello (@RequestParam Integer age,
                         Model model,
                         UserReadDto userReadDto) {
        model.addAttribute("user", userReadDto);
        return "greeting/hello";
    }

    @GetMapping("/bye")
    public String bye () {
        return "greeting/bye";
    }

}
