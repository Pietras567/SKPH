package Report;

import Classes.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController implements IReport {

    @Autowired
    private ReportService reportService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<Report>> getAllReports() {
        return reportService.getAllReports();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Report> getReport(@PathVariable int id) {
        return reportService.getReport(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable int id, @RequestBody Report updatedReport) {
        return reportService.updateReport(id, updatedReport);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Report> deleteReport(@PathVariable int id) {
        return reportService.deleteReport(id);
    }

    @Override
    @GetMapping("/charity/{id}")
    public ResponseEntity<List<Report>> getReportByOrganizationId(@PathVariable int id) {
        return reportService.getReportByOrganizationId(id);
    }

    @Override
    @GetMapping("/victim/{id}")
    public ResponseEntity<List<Report>> getReportByVictimId(@PathVariable int id) {
        return reportService.getReportByVictimId(id);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Report> addReport(@RequestBody InitialReport report) {
        System.out.println("report");
        return reportService.addReport(report);
    }

    public static class InitialReport {
        private int victim;
        private String category;
        private int location;
        private String reportStatus;
        private String reportDate;

        public int getVictim() { return victim; }

        public String getCategory() { return category; }

        public int getLocation() { return location; }

        public String getReportStatus() { return reportStatus; }

        public String getReportDate() { return reportDate; }

        public InitialReport(int victim, String category, int location, String reportStatus, String reportDate) {
            this.victim = victim;
            this.category = category;
            this.location = location;
            this.reportStatus = reportStatus;
            this.reportDate = reportDate;
        }
    }
}
