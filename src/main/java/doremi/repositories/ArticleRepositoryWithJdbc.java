package doremi.repositories;

import doremi.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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

    @Override
    public Article findArticleById(int id) {
        String sql = "SELECT * FROM articles WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Article(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("categorie")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Article saveArticle(Article article) {
        if (article == null) {
            throw new InvalidDataAccessApiUsageException("Impossible de sauvegarder un article null");
        }

        String checkSql = "SELECT COUNT(*) FROM articles WHERE id = ?";
        String insertSql = "INSERT INTO articles (id, title, categorie) VALUES (?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, article.getArticleId());
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    throw new InvalidDataAccessApiUsageException("L'article avec ID " + article.getArticleId() + " existe déjà");
                }
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, article.getArticleId());
                insertStmt.setString(2, article.getTitle());
                insertStmt.setString(3, article.getCategory());

                int affectedRows = insertStmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new RuntimeException("Échec de l'insertion de l'article");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion de l'article en base", e);
        }

        return article;
    }

}