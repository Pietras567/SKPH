import Classes.Charity;
import Classes.Donator;
import Classes.User;
import Classes.Victim;
import db.CharityRepository;
import db.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class DonatorCRUDTest {

    private UsersRepository repo;
    private Donator user;

    private Charity charity;

    private CharityRepository charityRepo;

    @BeforeEach
    public void setUp() {
        user = new Donator("firstName", "lastName", "123", "e@wp.pl", "123", LocalDate.now(), charity);
        repo = new UsersRepository();
        charityRepo = new CharityRepository();
        charity = new Charity("zubr", "organizacja pomocowa od 1978 roku w Polsce");
    }
    @AfterEach
    void cleanUp() {
        repo.getAll().forEach(user -> repo.remove(user.getUserId()));
        charityRepo.getAll().forEach(charity -> charityRepo.remove(charity.getCharity_id()));
    }

    @Test
    public void addTest() {
        charityRepo.add(charity);
        repo.add(user);
        User returnedUser = repo.get(user.getUserId());

        Assertions.assertEquals(user.getUserId(), returnedUser.getUserId());
        Assertions.assertEquals(user.getFirstName(), returnedUser.getFirstName());
        Assertions.assertEquals(user.getLastName(), returnedUser.getLastName());
    }

    @Test
    public void removeTest() {
        charityRepo.add(charity);
        repo.add(user);
        repo.remove(user.getUserId());
        User returnedUser = repo.get(user.getUserId());
        Assertions.assertNull(returnedUser);
    }

    @Test
    public void updateTest() {
        charityRepo.add(charity);
        repo.add(user);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        repo.update(user);
        User returnedUser = repo.get(user.getUserId());
        Assertions.assertEquals(user.getUserId(), returnedUser.getUserId());
        Assertions.assertEquals(user.getFirstName(), returnedUser.getFirstName());
        Assertions.assertEquals(user.getLastName(), returnedUser.getLastName());
    }

    @Test
    public void getAllTest() {
        charityRepo.add(charity);
        repo.add(user);
        User user2 = new Donator("firstName", "lastName", "123", "we@wp.pl", "123", LocalDate.now(), charity);
        repo.add(user2);
        Assertions.assertEquals(2, repo.getAll().size());
    }

}
