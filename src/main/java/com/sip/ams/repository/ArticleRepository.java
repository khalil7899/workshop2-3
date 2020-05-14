package com.sip.ams.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sip.ams.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
