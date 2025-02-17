package doremi.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Article {

    @Min(0)
    private int articleId;
    @NotBlank
    private String title;
    private String category;

    public Article(int id, String title, String category) {
        setArticleId(id);
        setTitle(title);
        setCategory(category);
    }

    public Article() { }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
