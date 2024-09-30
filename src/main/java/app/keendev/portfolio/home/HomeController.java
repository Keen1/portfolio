package app.keendev.portfolio.home;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //map home page
    @GetMapping("/")
    public String home(){
        return "home";
    }


}
