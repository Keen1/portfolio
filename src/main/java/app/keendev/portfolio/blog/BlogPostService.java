package app.keendev.portfolio.blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class BlogPostService {
    private BlogPostRepository blogPostRepository;
    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPost> getPosts(){
        return blogPostRepository.findAll().reversed();
    }

    public void savePost(BlogPost blogPost){
        if(blogPost.getDate() == null){
            blogPost.setDate(LocalDate.now());
        }
        if(blogPost.getTime() == null){
            blogPost.setTime(LocalTime.now());
        }
        blogPostRepository.save(blogPost);

    }

    public BlogPost getPostById(String id){
        return blogPostRepository.findById(id).orElse(null);
    }

    public void deletePost(String id){
        blogPostRepository.deleteById(id);
    }
    public void updatePost(String id, BlogPost updatedPost){

        BlogPost existingPost = blogPostRepository.findById(id).orElse(null);

        if(existingPost != null){
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            blogPostRepository.save(existingPost);
        }
    }


}
