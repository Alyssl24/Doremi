package doremi.services;

import doremi.domain.Article;
import doremi.repositories.ArticleRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    ArticleRepositoryInt articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepositoryInt articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAllArticles() {
        return this.articleRepository.findAllArticles();
    }

    public ArticleRepositoryInt getArticleRepository() {
        return this.articleRepository;
    }

    public Article findArticleById(int id) {
        return this.articleRepository.findArticleById(id);
    }
}
