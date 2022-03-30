package peaksoft.pagination.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Beksultan
 */
@Entity
@Table(name = "cars")
@Getter @Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String brand;

    private String model;

    private int yearOfIssue;

    public Car() {
    }

    public Car(String brand, String model, int yearOfIssue) {
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
    }
}
