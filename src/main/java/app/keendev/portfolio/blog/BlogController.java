package app.keendev.portfolio.blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blog")
    public String showBlogPosts(Model model){
        model.addAttribute("posts", blogPostService.getPosts());
        return "blog";
    }


}
