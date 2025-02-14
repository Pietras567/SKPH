import Classes.*;
import SKPH.SkphApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.CharityRepository;
import db.DonationsRepository;
import db.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = SkphApplication.class)
@AutoConfigureMockMvc
public class IDonationImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private IDonationImpl impl;
    private UsersRepository userRepo;
    private DonationsRepository donationsRepository;
    private CharityRepository charityRepo;
    private Charity charity;
    private Charity charity1;
    private User user;
    private User user1;
    private Donation donation;
    private Donation donation1;


    @BeforeEach
    public void setUp() {
        impl = new IDonationImpl();
        charity = new Charity("Pomoc","Pomagamy");
        charity1 = new Charity("CzerwonyKrzyz","Pomagamy zawsze");
        user = new Donator("Jan", "Nowak", "0", "jan.kowalski@example.com", "500600700", LocalDate.of(2024, 1, 29), charity);
        user1 = new Donator("Adam", "Nowak", "0", "adam.kowalski@example.com", "500600701", LocalDate.of(2024, 1, 29), charity1);
        donation = new Donation((Donator) user, donationStatus.pending, Date.valueOf("2023-12-08"),null);
        donation1 = new Donation((Donator) user1, donationStatus.pending, Date.valueOf("2024-12-08"),null);
        userRepo = new UsersRepository();
        donationsRepository = new DonationsRepository();
        charityRepo = new CharityRepository();


    }

    @AfterEach
    void cleanUp() {
        donationsRepository.getAll().forEach(donation -> donationsRepository.remove(donation.getDonation_id()));
        userRepo.getAll().forEach(user -> userRepo.remove(user.getUserId()));
        charityRepo.getAll().forEach(charity -> charityRepo.remove(charity.getCharity_id()));
    }

    @Test
    public void GetAllTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        donationsRepository.add(donation);

        charityRepo.add(charity1);
        userRepo.add(user1);
        donationsRepository.add(donation1);

        Assertions.assertEquals(HttpStatus.OK, impl.getAllDonations().getStatusCode());

        List<Donation> response = impl.getAllDonations().getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals("Jan", response.getFirst().getDonator().getFirstName());
        Assertions.assertEquals("Pomagamy", response.get(0).getDonator().getCharity().getCharity_description());
        Assertions.assertEquals(donationStatus.pending,response.get(0).getStatus());
        Assertions.assertEquals("Adam", response.get(1).getDonator().getFirstName());
        Assertions.assertEquals("Pomagamy zawsze", response.get(1).getDonator().getCharity().getCharity_description());
        Assertions.assertEquals(donationStatus.pending,response.get(1).getStatus());
    }

    @Test
    public void GetDonationByIdTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        donationsRepository.add(donation);

        ResponseEntity<Donation> response1 = impl.getDonationById(donation.getDonation_id());
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());

        Donation response = response1.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Jan", response.getDonator().getFirstName());
        Assertions.assertEquals("Pomagamy", response.getDonator().getCharity().getCharity_description());
        Assertions.assertEquals(donationStatus.pending,response.getStatus());

        ResponseEntity<Donation> response2 = impl.getDonationById(-1);
        Assertions.assertEquals(response2.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void getDonationByCharityIdTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        donationsRepository.add(donation);

        ResponseEntity<List<Donation>> response1 = impl.getDonationByCharityId(charity.getCharity_id());
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());

        List<Donation> response = response1.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals("Jan", response.getFirst().getDonator().getFirstName());
        Assertions.assertEquals("Pomagamy", response.getFirst().getDonator().getCharity().getCharity_description());
        Assertions.assertEquals(donationStatus.pending,response.getFirst().getStatus());
    }

    @Test
    public void getDonationByDonatorIdTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        donationsRepository.add(donation);

        ResponseEntity<List<Donation>> response1 = impl.getDonationByDonatorId(donation.getDonator().getUserId());
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());

        List<Donation> response = response1.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals("Jan", response.getFirst().getDonator().getFirstName());
        Assertions.assertEquals("Pomagamy", response.getFirst().getDonator().getCharity().getCharity_description());
        Assertions.assertEquals(donationStatus.pending,response.getFirst().getStatus());
    }

    @Test
    public void updateDonationTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        donationsRepository.add(donation);

        Assertions.assertEquals(Date.valueOf("2023-12-08"),donation.getDonationDate());
        Assertions.assertNull(donation.getAcceptDate());
        Assertions.assertEquals(donationStatus.pending,donation.getStatus());

        donation.setDonationDate(Date.valueOf("2023-12-18"));
        donation.setAcceptDate(Date.valueOf("2023-12-19"));
        donation.setStatus(donationStatus.accepted);

        impl.updateDonation(donation.getDonation_id(), donation);

        Assertions.assertEquals(Date.valueOf("2023-12-18"),donation.getDonationDate());
        Assertions.assertEquals(Date.valueOf("2023-12-19"),donation.getAcceptDate());
        Assertions.assertEquals(donationStatus.accepted,donation.getStatus());
    }

    @Test
    public void DeleteDonationTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);
        donationsRepository.add(donation);

        Assertions.assertEquals(1, donationsRepository.getAll().size());

        impl.deleteDonation(-1);

        Assertions.assertEquals(1, donationsRepository.getAll().size());

        ResponseEntity<Donation> response1 = impl.deleteDonation(donation.getDonation_id());

        Donation response = response1.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Jan", response.getDonator().getFirstName());
        Assertions.assertEquals("Pomagamy", response.getDonator().getCharity().getCharity_description());
        Assertions.assertEquals(donationStatus.pending,response.getStatus());
        Assertions.assertEquals(0, donationsRepository.getAll().size());
    }

    @Test
    public void createDonationTest() throws Exception {
        charityRepo.add(charity);
        userRepo.add(user);

        Assertions.assertEquals(0, donationsRepository.getAll().size());

        ResponseEntity<Donation> response1 = impl.createDonation(donation);
        Assertions.assertEquals(HttpStatus.CREATED, response1.getStatusCode());

        Donation response = response1.getBody();

        Donation don = donationsRepository.getAll().getFirst();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(don.getAcceptDate(), response.getAcceptDate());
        Assertions.assertEquals(don.getDonationDate().toString(), response.getDonationDate().toString());
        Assertions.assertEquals(don.getStatus(), response.getStatus());

    }

}
