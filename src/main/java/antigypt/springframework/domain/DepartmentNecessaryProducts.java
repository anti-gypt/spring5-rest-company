package antigypt.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by omid on 11/20/2020.
 */
@Entity
@Table(name = "NecessaryProduct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentNecessaryProducts extends Products {

    @OneToOne
    @JoinColumn(name = "departmentId")
    private Department department;

}
