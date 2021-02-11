package antigypt.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by omid on 11/17/2020.
 */
@Entity
@Table(name = "Vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    @Column(name = "vehicleModel")
    private String vehicleModel;
    @Column(name = "yearOfMake")
    private LocalDate yearOfMake;
    @Column(name = "price")
    private Double price;
    @Column(name = "plaque")
    private String plaque;
    @Column(name = "additionalDetails")
    private String additionalDetails;
    @Column(name = "postalCode")
    private String postalCode;


    @Enumerated(EnumType.STRING)
    private VehicleType vehiclType;
    @Enumerated(EnumType.STRING)
    private VehicleCondition vehicleCondition;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @Enumerated(EnumType.STRING)
    private Owner owner;

    @Lob
    @Column(name = "image")
    private Byte[] image;

    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private Employee employee;

    //@OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    //private VehicleControl vehicleControl;


}
