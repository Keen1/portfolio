package app.keendev.portfolio.blog;

public class ContentBlock {
    private String type;
    private String content;

    public ContentBlock(String type, String content){
        this.type = type;
        this.content = content;
    }

    public String getType(){
        return this.type;
    }

    public String getContent(){
        return this.content;
    }
}
