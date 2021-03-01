package antigypt.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by omid on 11/20/2020.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "expirationDate")
    private LocalDate expirationDate;
    @Column(name = "produceDate")
    private LocalDate produceDate;
    @Column(name = "price")
    private Double price;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "productCount")
    private Long productCount;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "detail")
    private String detail;
    @Lob
    @Column(name = "serialNumber")
    private Byte[] serialNumber;
    @Lob
    @Column(name = "image")
    private Byte[] image;

    @ManyToOne
    @JoinColumn(name = "productTypeId")
    private ProductType productType;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "producersId")
    //private Producers producers;

}
