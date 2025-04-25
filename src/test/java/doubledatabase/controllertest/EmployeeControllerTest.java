package doubledatabase.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.casestudy.doubledatabase.controller.EmployeeController;
import com.casestudy.doubledatabase.dto.EmployeeRequest;
import com.casestudy.doubledatabase.dto.EmployeeResponse;
import com.casestudy.doubledatabase.job.entity.EmployeeJob;
import com.casestudy.doubledatabase.job.repo.EmployeeJobRepo;
import com.casestudy.doubledatabase.personal.entity.EmployeePersonal;
import com.casestudy.doubledatabase.personal.repo.EmployeePersonalRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
 
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeePersonalRepo personalRepo;

    @Mock
    private EmployeeJobRepo jobRepo;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testCreateEmployee() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        request.setName("John Doe");
        request.setPhone("1234567890");
        request.setDepartment("Engineering");
        request.setSalary(100000.0);

        EmployeePersonal personal = new EmployeePersonal();
        personal.setId(1L);
        personal.setName("John Doe");
        personal.setPhone("1234567890");

        EmployeeJob job = new EmployeeJob();
        job.setId(1L);
        job.setDepartment("Engineering");
        job.setSalary(100000.0);

        when(personalRepo.save(any(EmployeePersonal.class))).thenReturn(personal);
        when(jobRepo.save(any(EmployeeJob.class))).thenReturn(job);

        mockMvc.perform(post("/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\",\"phone\":\"1234567890\",\"department\":\"Engineering\",\"salary\":100000}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee created with ID: 1"));
    }

    @Test
    public void testGetEmployee() throws Exception {
        EmployeePersonal personal = new EmployeePersonal();
        personal.setId(1L);
        personal.setName("John Doe");
        personal.setPhone("1234567890");

        EmployeeJob job = new EmployeeJob();
        job.setId(1L);
        job.setDepartment("Engineering");
        job.setSalary(100000.0);

        when(personalRepo.findById(1L)).thenReturn(java.util.Optional.of(personal));
        when(jobRepo.findById(1L)).thenReturn(java.util.Optional.of(job));

        mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"John Doe\",\"phone\":\"1234567890\",\"department\":\"Engineering\",\"salary\":100000}"));
    }
}
