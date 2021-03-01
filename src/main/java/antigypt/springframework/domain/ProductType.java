package antigypt.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by omid on 11/19/2020.
 */
@Entity
@Table(name = "ProductType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productTypeId;
    @Column(name = "productTypeName")
    private ProductTypeName productTypeName;
    @Column(name = "productCategory")
    private ProductCategory productCategory;
    @Column(name = "detail")
    private String detail;

    @OneToMany(mappedBy = "productType" , cascade = CascadeType.ALL)
    private List<DepartmentProducts> departmentProductsList = new ArrayList<>();
    @OneToMany(mappedBy = "productType" , cascade = CascadeType.ALL)
    private List<DepartmentCorruptProducts> departmentCorruptProductsList = new ArrayList<>();
    @OneToMany(mappedBy = "productType" , cascade = CascadeType.ALL)
    private List<DepartmentNecessaryProducts> departmentNecessaryProductsList = new ArrayList<>();

}
