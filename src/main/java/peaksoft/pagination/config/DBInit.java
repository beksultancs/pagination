package peaksoft.pagination.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import peaksoft.pagination.model.Car;
import peaksoft.pagination.repositories.CarRepository;

import java.util.Arrays;

/**
 * @author Beksultan
 */
@Component
public class DBInit {

//    @Bean
    CommandLineRunner runner(CarRepository carRepository) {
        return args -> {
            carRepository.saveAll(Arrays.asList(
                    new Car("Tesla", "Model Y", 2020),
                    new Car("Mercedes", "S class", 2020),
                    new Car("Lamborgini", "Aventador", 2020),
                    new Car("Hyundai", "Sonata", 2020),
                    new Car("Toyota", "Alphard", 2020),
                    new Car("Honda", "CRV", 2020),
                    new Car("Wolksvagen", "Passat", 2020),
                    new Car("Bugatti", "Veyron", 2020),
                    new Car("Lexus", "LX 570", 2020),
                    new Car("Toyota", "Prado", 2020),
                    new Car("Tesla", "Model X", 2020),
                    new Car("Audi", "A6", 2020),
                    new Car("Honda", "Fit", 2020),
                    new Car("Tesla", "SuperCar", 2020),
                    new Car("Tesla", "Model Y", 2020)
            ));
        };
    }
}
