package Report;

import Classes.Report;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface IReport {
    ResponseEntity<List<Report>> getAllReports();

    ResponseEntity<Report> getReport(@PathVariable int id);

    ResponseEntity<Report> updateReport(@PathVariable int id, @RequestBody Report updatedReport);

    ResponseEntity<Report> deleteReport(@PathVariable int id);

    ResponseEntity<List<Report>> getReportByOrganizationId(@PathVariable int id);

    ResponseEntity<List<Report>> getReportByVictimId(@PathVariable int id);

    ResponseEntity<Report> addReport(@RequestBody ReportController.InitialReport report);
}
