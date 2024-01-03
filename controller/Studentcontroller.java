//package Task1.demo.controller;
//
//import Task1.demo.entity.Student;
//import Task1.demo.exception.ResourceNotFoundException;
//import Task1.demo.repo.Studentrepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("/api/s/")
//public class Studentcontroller {
//    @Autowired
//    private Studentrepo studentrepo;
//
//    @GetMapping("student")
//    public List<Student> get() {
//        return this.studentrepo.findAll();
//    }
//
//    @GetMapping("/student/{id}")
//    public ResponseEntity<Student> getbyid(@PathVariable("id") Integer id)
//            throws ResourceNotFoundException {
//        Student student = studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//        return ResponseEntity.ok().body(student);
//    }
//
//    @PostMapping("/student")
//    public Student poststudent(@RequestBody Student student) {
//        System.out.println(student);
//        return studentrepo.save(student);
//    }
//
//    @PutMapping("/student/{id}")
//    public ResponseEntity<Student> updatestudent(@PathVariable(value = "id") Integer id, @Validated @RequestBody Student studentdetials)
//        throws ResourceNotFoundException {
//            Student student = studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//
//            student.firstname = studentdetials.firstname;
//            student.lastname = studentdetials.lastname;
//            return ResponseEntity.ok(this.studentrepo.save(student));
//
//        }
//        @DeleteMapping("/student/{id}")
//    public Map<String,Boolean> Deletestudent(@PathVariable("id") Integer id)
//                throws ResourceNotFoundException {
//            Student student = studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//            this.studentrepo.delete(student);
//            Map<String,Boolean>response=new HashMap<>();
//            response.put("delete",Boolean.TRUE);
//            return response;
//        }
//
//
//}
