package antigypt.springframework.controllers.api.v1;

import antigypt.springframework.Services.DepartmentService;
import antigypt.springframework.Services.EmployeeService;
import antigypt.springframework.api.v1.model.DepartmentDTO;
import antigypt.springframework.api.v1.model.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(DepartmentController.BASE_URL)
public class DepartmentController {
    public static final String BASE_URL = "api/v1/departments";
    public static final String CREATE_UPDATE_FORM = "departments/departmentForm";
    public static final String DEPARTMENTS_SHOW = "departments/show";
    public static final String DEPARTMENT_LIST = "departments/departmentList";

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;
    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String createNewDepartmentForm(Model model){
        model.addAttribute("departmentForm",new DepartmentDTO());
        return "departments/departmentForm";
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String processDepartmentCreationForm(@ModelAttribute @Valid DepartmentDTO departmentDTO, BindingResult bindingResult, Model model){
        if (departmentService.isNew(departmentDTO) == false){
            bindingResult.rejectValue("email" , "duplicate" , "already exists");
            if (bindingResult.hasErrors()){
                model.addAttribute("departmentForm",departmentDTO);
                return CREATE_UPDATE_FORM;
            }
        }
        DepartmentDTO savedDepartmentDTO = departmentService.createNewDepartment(departmentDTO);
        return "redircet:/"+DepartmentController.BASE_URL+"/"+savedDepartmentDTO.getDepartmetnUrl().split("/")[4];
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String showDepartmentDetails(@PathVariable Long id , Model model){
        model.addAttribute("department" , departmentService.findDepartmentById(id));
        return DEPARTMENTS_SHOW;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String showAllDepartments(Model model){
        model.addAttribute("departments" , departmentService.getAllDepartments());
        return DEPARTMENT_LIST;
    }



    @GetMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return "redirect:/"+DepartmentController.BASE_URL;
    }

    @GetMapping("/{id}/update")
    public String initialDepartmentUpdateForm(@PathVariable Long id , Model model){
        model.addAttribute("departmentForm" , departmentService.findDepartmentById(id));
        return CREATE_UPDATE_FORM;
    }
    @GetMapping("/{departmentName}")
    @ResponseStatus(HttpStatus.OK)
    public String processFindingAllDepartmentsByName(@PathVariable String departmentName, Model model){
        if (departmentName == null || departmentName.trim().equals("")){
            departmentName = " ";
        }
        List<DepartmentDTO> foundedDepartments = departmentService.findDepartmentByName("%"+departmentName+"%");
        if (foundedDepartments.size() == 0){
            return "departments/departmentSearchForm";
        }
        if (foundedDepartments.size() == 1 ){
            return DEPARTMENTS_SHOW;
        }
        return DEPARTMENT_LIST;
    }
    @GetMapping("/{id}/employees/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String initialCreationNewEmployeeForDepartment(@RequestParam @Valid EmployeeDTO employeeDTO , @PathVariable Long id){
        employeeService.createNewEmployee(id,employeeDTO);
        return "redirect:/"+DepartmentController.BASE_URL +"/"+id;
    }
}
