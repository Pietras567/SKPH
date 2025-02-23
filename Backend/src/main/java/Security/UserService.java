package Security;

import Classes.*;
import Mail.MailManager;
import Resources.Resource;
import Resources.Volunteer;
import db.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepository usersRepository = new UsersRepository();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtConfig jwtConfig = new JwtConfig();
    private final JwtUtils jwtUtils = new JwtUtils(jwtConfig);

    @Autowired
    private MailManager mailManager;

    public boolean register(RegisterRequest request) {

        Optional<User> existingUser = usersRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        switch(request.getRole()) {
            case "victim":
                Victim victim = new Victim();
                victim.setFirstName(request.getFirstName());
                victim.setLastName(request.getLastName());
                victim.setPasswordHash(hashedPassword);
                victim.setEmail(request.getEmail());
                victim.setPhoneNumber(request.getPhone());
                victim.setRegistrationDate(LocalDate.now());
                new UsersRepository().update(victim);
                break;
            case "volunteer":
                Volunteer volunteer = new Volunteer(request.getFirstName(), request.getLastName(), request.getPassword(),
                        request.getEmail(), request.getPhone(), LocalDate.now());
                volunteer.setLastActivityTime(LocalDateTime.now());
                volunteer.setPasswordHash(hashedPassword);
                volunteer.setResource(new Resource(volunteer));
                new UsersRepository().add(volunteer);
                break;
            case "donator":
                Donator donator = new Donator(request.getFirstName(), request.getLastName(), null);
                donator.setLastActivityTime(LocalDateTime.now());
                donator.setPasswordHash(hashedPassword);
                donator.setEmail(request.getEmail());
                donator.setPhoneNumber(request.getPhone());
                donator.setRegistrationDate(LocalDate.now());
                new UsersRepository().add(donator);
                break;
            default:
                return false;
        }
        return true;
    }

    public LoginResponse login(LoginRequest request) {
        Optional<User> user = usersRepository.findByEmail(request.getEmail());

        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPasswordHash())) {
            User loggedInUser = user.get();
            loggedInUser.setLastActivityTime(LocalDateTime.now());
            usersRepository.update(loggedInUser);
            return new LoginResponse(Integer.toString(loggedInUser.getUserId()), jwtUtils.generateToken(loggedInUser), "success");
        }

        throw new IllegalArgumentException("Niepoprawny login lub hasło.");
    }

    public boolean update(UpdateRequest request) {

        Optional<User> existingUser = usersRepository.findByEmail(request.getEmail());

        if (existingUser.isEmpty()) {
            return false;
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        existingUser.get().setFirstName(request.getFirstName());
        existingUser.get().setLastName(request.getLastName());
        existingUser.get().setPasswordHash(hashedPassword);
        existingUser.get().setEmail(request.getEmail());
        existingUser.get().setPhoneNumber(request.getPhone());

        return true;
    }

    public User getUserInfo(int id){
        return usersRepository.get(id);
    }
}
