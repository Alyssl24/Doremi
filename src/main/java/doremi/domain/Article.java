package doremi.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return articleId == article.articleId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleId);
    }
}
