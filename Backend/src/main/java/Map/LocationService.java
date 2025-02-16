package Map;

import Classes.Location;
import db.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @PostConstruct
    public void LocationServiceRepository() {
        this.locationRepository = new LocationRepository();
    }

    public ResponseEntity<Location> addLocation(Location location) {
        locationRepository.add(location);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    public ResponseEntity<Location> getLocationById(int id) {
        Location location = locationRepository.get(id);
        if (location == null) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.getAll();
        if (locations == null) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteLocation(int id) {
        if (locationRepository.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        locationRepository.remove(id);
        if (locationRepository.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
