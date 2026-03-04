package app.entities;
public class Post {

    private final int id;
    private final String title;
    private final String content;
    private final String image;

    public Post(int id, String title, String content, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public boolean hasImage() {
        return image != null && !image.isBlank();
    }
}
