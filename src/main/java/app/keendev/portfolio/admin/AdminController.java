package app.keendev.portfolio.admin;
import app.keendev.portfolio.blog.BlogPost;
import app.keendev.portfolio.blog.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public String adminPanel(Model model){
        List<BlogPost> posts = blogPostService.getPosts();
        model.addAttribute("posts", posts);

        return "admin";

    }

    @GetMapping("/create")
    public String createBlogPostForm(Model model){
        model.addAttribute("blogPost", new BlogPost());
        return"create";
    }

    @PostMapping("/create")
    public String createBlogPost(@ModelAttribute BlogPost blogPost){
        blogPostService.savePost(blogPost);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editBlogPostForm(@PathVariable String id, Model model){
        BlogPost post = blogPostService.getPostById(id);
        model.addAttribute("blogPost", post);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBlogPost(@PathVariable String id, @ModelAttribute BlogPost updatedPost){
        blogPostService.updatePost(id, updatedPost);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlogPost(@PathVariable String id){
        blogPostService.deletePost(id);
        return "redirect:/admin";
    }

}
