package doremi.repositories;

import doremi.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepositoryWithJdbc implements ArticleRepositoryInt {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Article> findAllArticles() {
        String sql = "SELECT * FROM articles";
        List<Article> articles = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("categorie")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }
}