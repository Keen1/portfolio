package app.keendev.portfolio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //map home page
    @GetMapping("/")
    public String home(){
        return "home";
    }

    //map blog page
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }


}
