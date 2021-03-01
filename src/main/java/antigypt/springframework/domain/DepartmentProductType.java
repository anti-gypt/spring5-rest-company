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
@Table(name = "departmentProductType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentProductType {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")
    private Department departmentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productTypeId")
    private ProductType productTypeId;
    @ManyToMany
    @JoinTable(name = "departmentProductType" ,
            joinColumns = @JoinColumn(name = "productTypeId"),
            inverseJoinColumns = @JoinColumn(name = "departmentId"))
    List<Department> departmentList = new ArrayList<>();

}
