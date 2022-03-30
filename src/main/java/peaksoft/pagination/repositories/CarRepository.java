package peaksoft.pagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import peaksoft.pagination.model.Car;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID>, PagingAndSortingRepository<Car, UUID> {
}