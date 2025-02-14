import Classes.*;
import SKPH.SkphApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.CharityRepository;
import db.ReportRepository;
import db.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.time.LocalDate;

import java.util.List;

@SpringBootTest(classes = SkphApplication.class)
@AutoConfigureMockMvc
public class IReportImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private IReportImpl impl;
    private UsersRepository userRepo;
    private ReportRepository reportRepo;
    private CharityRepository charityRepo;
    private Charity charity;
    private Charity charity2;
    private User user;
    private User user2;
    private Report report;
    private Report report2;


    @BeforeEach
    public void setUp() {
        impl = new IReportImpl();
        charity = new Charity("Caritas", "Pomoc dla bezdomnych");
        charity2 = new Charity("Charity", "Opis");
        user = new Victim("Jeremiasz", "Rożowy","haslo","jeremias@wp.pl","123", LocalDate.now(), charity);
        user2 = new Victim("Włodzimierz", "Biały","haslo","wlodzimierz@wp.pl", "000", LocalDate.now(), charity2);
        report = new Report((Victim) user, "Zaginął pies", charity);
        report2 = new Report((Victim) user2, "Zaginął kot", charity2);
        userRepo = new UsersRepository();
        reportRepo = new ReportRepository();
        charityRepo = new CharityRepository();

    }
    @AfterEach
    void cleanUp() {
        reportRepo.getAll().forEach(report -> reportRepo.remove(report.getReport_id()));
        userRepo.getAll().forEach(user -> userRepo.remove(user.getUserId()));
        charityRepo.getAll().forEach(charity -> charityRepo.remove(charity.getCharity_id()));
   }


    @Test
    public void GetAllTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        reportRepo.add(report);

        charityRepo.add(charity2);
        userRepo.add(user2);
        reportRepo.add(report2);

        Assertions.assertEquals(HttpStatus.OK, impl.getAllReports().getStatusCode());
        List<Report> reports =  impl.getAllReports().getBody();
        Assertions.assertEquals(2, reports.size());
        Assertions.assertEquals(report.getCategory(), reports.getFirst().getCategory());
        Assertions.assertEquals("Jeremiasz", reports.get(0).getVictim().getFirstName());
        Assertions.assertEquals("Pomoc dla bezdomnych", reports.get(0).getCharity().getCharity_description());
        Assertions.assertEquals(report2.getCategory(), reports.get(1).getCategory());
        Assertions.assertEquals("Włodzimierz", reports.get(1).getVictim().getFirstName());
        Assertions.assertEquals("Opis", reports.get(1).getCharity().getCharity_description());
    }

    @Test
    public void GetByReportId() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        reportRepo.add(report);


        ResponseEntity<Report> response = impl.getReport(report.getReport_id());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());




        Report reportget = response.getBody();

        Assertions.assertNotNull(reportget);
        Assertions.assertEquals(report.getCategory(), reportget.getCategory());
        Assertions.assertEquals("Jeremiasz", reportget.getVictim().getFirstName());
        Assertions.assertEquals("Pomoc dla bezdomnych", reportget.getCharity().getCharity_description());

       ResponseEntity<Report> response2 = impl.getReport(-1);
        Assertions.assertTrue(response2.getStatusCode().equals(HttpStatus.NOT_FOUND));
    }

    @Test
    public void GetByCharityId() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        reportRepo.add(report);

        ResponseEntity<List<Report>> wynik = impl.getReportByOrganizationId(charity.getCharity_id());
        Assertions.assertEquals(HttpStatus.OK, wynik.getStatusCode());

        List<Report> reports = wynik.getBody();

        Assertions.assertEquals(1, reports.size());
        Assertions.assertEquals(reports.getFirst().getCategory(), report.getCategory());
        Assertions.assertEquals("Jeremiasz", reports.getFirst().getVictim().getFirstName());
        Assertions.assertEquals("Pomoc dla bezdomnych", reports.getFirst().getCharity().getCharity_description());
    }

    @Test
    public void GetByUserId() throws Exception {
        charityRepo.add(charity2);
        userRepo.add(user2);
        reportRepo.add(report2);

        ResponseEntity<List<Report>> response = impl.getReportByVictimId(user2.getUserId());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Report> reports = response.getBody();

        Assertions.assertEquals(1, reports.size());
        Assertions.assertEquals(reports.getFirst().getCategory(), report2.getCategory());
        Assertions.assertEquals("Włodzimierz", reports.getFirst().getVictim().getFirstName());
        Assertions.assertEquals("Opis", reports.getFirst().getCharity().getCharity_description());
    }

    @Test
    public void AddReport() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);

        Assertions.assertEquals(0, reportRepo.getAll().size());


        ResponseEntity<Report> response = impl.addReport(report);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Report report = response.getBody();

        Report reportDB = reportRepo.getAll().getFirst();

        Assertions.assertNotNull(report);
        Assertions.assertEquals(reportDB.getCategory(), report.getCategory());
        Assertions.assertEquals(reportDB.getVictim().getFirstName(), report.getVictim().getFirstName());
        Assertions.assertEquals(reportDB.getCharity().getCharity_description(), report.getCharity().getCharity_description());
    }

    @Test
    public void DeleteReport() throws Exception {
        charityRepo.add(charity2);
        userRepo.add(user2);
        reportRepo.add(report2);

        Assertions.assertEquals(1, reportRepo.getAll().size());

        impl.deleteReport(-1);

        Assertions.assertEquals(1, reportRepo.getAll().size());

        ResponseEntity<Report> response = impl.deleteReport(report2.getReport_id());


        Report report2delete = response.getBody();

        Assertions.assertEquals(report2.getCategory(), report2delete.getCategory());
        Assertions.assertEquals("Włodzimierz", report2delete.getVictim().getFirstName());
        Assertions.assertEquals("Opis", report2delete.getCharity().getCharity_description());
        Assertions.assertEquals(0, reportRepo.getAll().size());
    }

    @Test
    public void UpdateReport() throws Exception {
        charityRepo.add(charity);
        charityRepo.add(charity2);
        userRepo.add(user);
        userRepo.add(user2);
        reportRepo.add(report2);

        Assertions.assertEquals("Zaginął kot", report2.getCategory());
        Assertions.assertEquals("Włodzimierz", report2.getVictim().getFirstName());
        Assertions.assertNull(report2.getStatus());

        report2.setStatus(reportStatus.accepted);
        report2.setCategory("Pożar");
        report2.setVictim((Victim) user);

        impl.updateReport(report2.getReport_id(), report2);

        Report report1 = reportRepo.get(report2.getReport_id());
        Assertions.assertEquals("Pożar", report1.getCategory());
        Assertions.assertEquals(reportStatus.accepted, report1.getStatus());
        Assertions.assertEquals("Jeremiasz", report1.getVictim().getFirstName());
    }
}
