package Map;

import Classes.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController implements ILocation {

    @Autowired
    private LocationService locationService;

    @Override
    @PostMapping("/locations")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @Override
    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    @Override
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        return  locationService.getAllLocations();
    }

    @Override
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id) {
        return locationService.deleteLocation(id);
    }
}
