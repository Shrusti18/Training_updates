//package Task1.demo.controller;
//
//import Task1.demo.entity.Studdetials;
//import Task1.demo.entity.Student;
//import Task1.demo.exception.ResourceNotFoundException;
//import Task1.demo.repo.Studentdetrepo;
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
//public class Studdetialscontroller {
//    @Autowired
//    private Studentdetrepo studentdetrepo;
//
//    @GetMapping("studentdetails")
//    public List<Studdetials> get() {
//        return this.studentdetrepo.findAll();
//    }
//
//    @GetMapping("/studentdetials/{id}")
//    public ResponseEntity<Studdetials> getbyid(@PathVariable("id") Integer id)
//            throws ResourceNotFoundException {
//        Studdetials studdetials = studentdetrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//        return ResponseEntity.ok().body(studdetials);
//    }
//
//    @PostMapping("studentdetials")
//    public Studdetials poststudent(@RequestBody Studdetials studdetials) {
//        System.out.println(studdetials);
//        return studentdetrepo.save(studdetials);
//    }
//
//    @PutMapping("/studentdetials/{id}")
//    public ResponseEntity<Studdetials> updatestudent(@PathVariable(value = "id") Integer id, @Validated @RequestBody Studdetials studentdetials)
//            throws ResourceNotFoundException {
//        Studdetials studdetials = studentdetrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//
//        studdetials.address = studentdetials.address;
//        studdetials.emailid = studentdetials.emailid;
//        studdetials.gender=studentdetials.gender;
//        return ResponseEntity.ok(this.studentdetrepo.save(studdetials));
//
//    }
//    @DeleteMapping("/studentdetials/{id}")
//    public Map<String,Boolean> Deletestudent(@PathVariable("id") Integer id)
//            throws ResourceNotFoundException {
//        Studdetials studdetials = studentdetrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//        this.studentdetrepo.delete(studdetials);
//        Map<String,Boolean>response=new HashMap<>();
//        response.put("delete",Boolean.TRUE);
//        return response;
//    }
//
//
//}
