package mikiponix.io.l4ssns;

public class Card {
    private String title;
    private String content;
    private int likeCount;

    public Card(String title, String content, int likeCount) {
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}