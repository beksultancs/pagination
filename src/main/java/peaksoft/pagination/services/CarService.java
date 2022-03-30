package peaksoft.pagination.services;

import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.pagination.model.Car;
import peaksoft.pagination.repositories.CarRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Beksultan
 */
@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CriteriaBuilder criteriaBuilder;
    private final EntityManager entityManager;

    public List<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable).getContent();
    }

    public List<Car> findBy(String model,
                            String brand,
                            Pageable pageable) {

        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);

        //car model
        Predicate carPredicate = Strings.isNullOrEmpty(model) ? criteriaBuilder.and() :
                criteriaBuilder.like(root.get("model"), model + "%");

        //car brand
        Predicate brandPredicate = Strings.isNullOrEmpty(brand) ? criteriaBuilder.and() :
                criteriaBuilder.like(root.get("brand"), brand + "%");

        criteriaQuery.select(root)
                .where(carPredicate, brandPredicate);

        TypedQuery<Car> carTypedQuery = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

        return carTypedQuery.getResultList();
    }
}
