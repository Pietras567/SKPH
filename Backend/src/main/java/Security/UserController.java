package Security;

import Classes.Donation;
import Classes.Donator;
import Classes.User;
import Classes.Victim;
import Resources.Volunteer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController implements ISecurity, IUser{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        try {
            boolean flag = userService.register(request);
            if (!flag){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"status\":\"error\"}");
            }
            return ResponseEntity.ok("{\"status\":\"success\"}");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"status\":\"error\"}");
        }
    }

    @Override
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok((userService.login(request)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(null, null, "error"));
        }
    }

    @Override
    public ResponseEntity<String> update(@RequestBody UpdateRequest request) {
        try {
            boolean flag = userService.update(request);
            if (!flag){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"status\":\"error\"}");
            }
            return ResponseEntity.ok("{\"status\":\"success\"}");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"status\":\"error\"}");
        }
    }

    @Override
    public ResponseEntity<GetRequest> getUser(int id) {
        User user = userService.getUserInfo(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        GetRequest getRequest = new GetRequest();
        getRequest.setId(String.valueOf(user.getUserId()));
        getRequest.setFirstname(user.getFirstName());
        getRequest.setSurname(user.getLastName());
        getRequest.setEmail(user.getEmail());
        getRequest.setPhone(user.getPhoneNumber());

        switch (user) {
            case Victim victim -> getRequest.setRole("victim");
            case Volunteer volunteer -> getRequest.setRole("volunteer");
            case Donator donator -> getRequest.setRole("donator");
            default -> getRequest.setRole("unknown");
        }

        return new ResponseEntity<>(getRequest, HttpStatus.OK);
    }
    
}

