package app.keendev.portfolio.blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends MongoRepository<BlogPost, String> {


}
