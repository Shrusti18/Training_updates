package Task1.demo.controller;

import Task1.demo.Service.StudentService;
import Task1.demo.entity.Marks;
import Task1.demo.entity.Studdetials;
import Task1.demo.entity.Student;
import Task1.demo.exception.ResourceNotFoundException;
import Task1.demo.repo.Marksrepo;
import Task1.demo.repo.Studentdetrepo;
import Task1.demo.repo.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/s/")
public class CombinedController {
    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Studentdetrepo studentdetrepo;

    @Autowired
    private Marksrepo marksrepo;

    @PostMapping("/createEntities")
    public ResponseEntity<?> createEntities(@RequestBody Map<String, Object> requestData) {
        try {

            Map<String, Object> studdetialsData = (Map<String, Object>) requestData.get("studdetials");
            String address = (String) studdetialsData.get("address");
            String gender = (String) studdetialsData.get("gender");
            String emailId = (String) studdetialsData.get("emailid");


            Studdetials studdetials = new Studdetials();
            studdetials.setAddress(address);
            studdetials.setGender(gender);
            studdetials.setEmailid(emailId);


            Studdetials savedStuddetials = studentdetrepo.save(studdetials);


            Map<String, Object> studentData = (Map<String, Object>) requestData.get("student");
            String firstName = (String) studentData.get("firstname");
            String lastName = (String) studentData.get("lastname");


            Student student = new Student();
            student.setFirstname(firstName);
            student.setLastname(lastName);
            student.setStuddetials(savedStuddetials);


            Map<String, Object> marksData = (Map<String, Object>) requestData.get("marks");
            String subject = (String) marksData.get("subject");
            Float marks = Float.parseFloat(marksData.get("marks").toString());


            Marks marksEntity = new Marks();
            marksEntity.setSubject(subject);
            marksEntity.setMarks(marks);


            student.setMarks(marksEntity);


            studentrepo.save(student);

            return ResponseEntity.ok("Entities created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating entities: " + e.getMessage());
        }


    }

    @GetMapping("/getData")
    public Map<String, Object> getCombinedData() {
        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("student", this.studentrepo.findAll());
        combinedData.put("studentDetails", this.studentdetrepo.findAll());
        combinedData.put("marks", this.marksrepo.findAll());
        return combinedData;
    }

    @DeleteMapping("/deleteEntity/{entity}/{id}")
    public Map<String, Boolean> deleteEntity(
            @PathVariable("entity") String entity,
            @PathVariable("id") Integer id)
            throws ResourceNotFoundException {

        Map<String, Boolean> response = new HashMap<>();
        boolean isDeleted = false;

        switch (entity) {
            case "student":
                Student student = studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
                studentrepo.delete(student);
                isDeleted = true;
                break;

            case "studentdetails":
                Studdetials studdetials = studentdetrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student details not found for this id " + id));
                studentdetrepo.delete(studdetials);
                isDeleted = true;
                break;

            case "marks":
                Marks marks = marksrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marks not found for this id " + id));
                marksrepo.delete(marks);
                isDeleted = true;
                break;

            default:
                isDeleted = false;
                break;
        }

        response.put("delete", isDeleted);
        return response;
    }

    //    @PutMapping("/updateEntity/{entity}/{id}")
//    public ResponseEntity<Object> updateEntity(
//            @PathVariable("entity") String entity,
//            @PathVariable("id") Integer id,
//            @RequestBody Object updatedDetails)
//            throws ResourceNotFoundException {
//
//        switch (entity) {
//            case "studentdetails":
//                Studdetials studdetials = studentdetrepo.findById(id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Student details not found for this id " + id));
//                if (updatedDetails instanceof Studdetials) {
//                    Studdetials updatedstudent = (Studdetials) updatedDetails;
//
//
//                    studdetials.setAddress(updatedstudent.getAddress());
//                    studdetials.setGender(updatedstudent.getGender());
//
//
//                    return ResponseEntity.ok(this.studentdetrepo.save(studdetials));
//                } else {
//                    return ResponseEntity.badRequest().body("Invalid data format for Marks update");
//                }
//
//
//            case "marks":
//                Marks marks = marksrepo.findById(id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Marks not found for this id " + id));
//                if (updatedDetails instanceof Marks) {
//                    Marks updatedMarks = (Marks) updatedDetails;
//
//
//                    marks.setSubject(updatedMarks.getSubject());
//                    marks.setMarks(updatedMarks.getMarks());
//
//
//                    return ResponseEntity.ok(this.marksrepo.save(marks));
//                } else {
//                    return ResponseEntity.badRequest().body("Invalid data format for Marks update");
//                }
//
//
//            case "student":
//                Student student = studentrepo.findById(id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//                if (updatedDetails instanceof Student) {
//                    Student updatedstudent = (Student) updatedDetails;
//
//
//                    student.setFirstname(updatedstudent.getFirstname());
//                    student.setLastname(updatedstudent.getLastname());
//
//
//                    return ResponseEntity.ok(this.studentrepo.save(student));
//                } else {
//                    return ResponseEntity.badRequest().body("Invalid data format for Marks update");
//                }
//
//            default:
//                return ResponseEntity.badRequest().body("Invalid entity type");
//        }
////    }
//
//    }
//}



//    @Autowired
//    private StudentService studentService;
//
//    @PutMapping("/students/{studentId}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Integer studentId, @RequestBody Student updatedStudent) {
//        Student updated = studentService.updateStudentDetails(studentId, updatedStudent);
//        return ResponseEntity.ok(updated);
//    }
}