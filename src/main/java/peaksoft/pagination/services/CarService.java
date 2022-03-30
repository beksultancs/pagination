package peaksoft.pagination.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.pagination.model.Car;
import peaksoft.pagination.repositories.CarRepository;

import java.util.List;

/**
 * @author Beksultan
 */
@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable).getContent();
    }
}
