package peaksoft.pagination.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Beksultan
 */
@Configuration
public class ApplicationConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }

    @Bean
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
