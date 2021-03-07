package antigypt.springframework.Services;

import antigypt.springframework.api.v1.model.DepartmentCorruptProductDTO;


import java.util.List;

public interface DepartmentCorruptProductService {
    DepartmentCorruptProductDTO createNewDepartmentProduct(DepartmentCorruptProductDTO departmentCorruptProductDTO);
    DepartmentCorruptProductDTO findDepartmentById(Long id);
    List<DepartmentCorruptProductDTO> getAllDepartments();
    DepartmentCorruptProductDTO updateDepartmentByDTO(Long id,DepartmentCorruptProductDTO departmentCorruptProductDTO);
    void deleteDepartmentById(Long id);
    boolean isNew(DepartmentCorruptProductDTO departmentCorruptProductDTO);
    List<DepartmentCorruptProductDTO> findAllByName(String productName);
}
