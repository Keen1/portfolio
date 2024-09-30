package app.keendev.portfolio.blog;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;

@Document(collection = "posts")
public class BlogPost {
    @Id
    private String id;
    private String title;
    private LocalDate date;
    private LocalTime time;

    private String content;

    public BlogPost(){

    }

    public BlogPost(String id, String title, String content, LocalDate date, LocalTime time){
        this.date = date;
        this.time = time;
        this.id = id;
        this.title = title;
        this.date = LocalDate.now();
        this.content = content;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public LocalTime getTime(){
        return this.time;
    }
    public void setTime(LocalTime time){
        this.time = time;
    }
    public String getFormattedDate(){
        if(this.date == null){
            return "date not available.";
        }
        return this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }
    public String getFormattedTime(){
        if(this.time == null){
            return "time not available.";
        }
        return this.time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
