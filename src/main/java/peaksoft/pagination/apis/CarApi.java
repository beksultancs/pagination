package peaksoft.pagination.apis;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.pagination.model.Car;
import peaksoft.pagination.services.CarService;

import java.util.List;

/**
 * @author Beksultan
 */
@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarApi {

    private final CarService carService;

    @GetMapping
    public List<Car> findAllCars(@RequestParam int page,
                                 @RequestParam int size) {
        return carService.findAll(PageRequest.of(page, size));
    }


    // with criteria query
    @GetMapping("/find/by")
    public List<Car> findBy(@RequestParam(required = false) String model,
                            @RequestParam(required = false) String brand,
                            @RequestParam(required = false) int page,
                            @RequestParam(required = false) int size) {
        return carService.findBy(model, brand, PageRequest.of(page, size));
    }

}
