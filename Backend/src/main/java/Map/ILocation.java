package Map;

import Classes.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ILocation {
    ResponseEntity<Location> addLocation(@RequestBody Location location);

    ResponseEntity<Location> getLocationById(@PathVariable int id);

    ResponseEntity<List<Location>> getAllLocations();

    ResponseEntity<Void> deleteLocation(@PathVariable int id);

}
