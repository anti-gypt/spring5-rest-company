package antigypt.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * Created by omid on 11/20/2020.
 */

@Entity
@Table(name="DepartmentProducts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentProduct extends Product {

    @OneToOne
    @JoinColumn(name = "departmentId")
    private Department department;


    //@ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable(name = "ProductBuyTrolley",
    //        joinColumns = @JoinColumn(name = "productId"),
    //        inverseJoinColumns = @JoinColumn(name = "buyTrolleyId"))
    //public List<BuyTrolley> buyTrolleyList = new ArrayList<>();

}
