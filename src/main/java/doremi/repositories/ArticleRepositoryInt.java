package doremi.repositories;

import doremi.domain.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleRepositoryInt {

    public List<Article> findAllArticles();

}
