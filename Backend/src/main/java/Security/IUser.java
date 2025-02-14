package Security;

import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUser {

    @PutMapping("/update")
    ResponseEntity<String> update(@RequestBody UpdateRequest request);

    @GetMapping("/user/{id}")
    ResponseEntity<GetRequest> getUser(@PathVariable int id);
}
