//package Task1.demo.controller;
//
//import Task1.demo.entity.Marks;
//import Task1.demo.exception.ResourceNotFoundException;
//import Task1.demo.repo.Marksrepo;
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
//public class Markscontroller {
//    @Autowired
//    private Marksrepo marksrepo;
//
//    @GetMapping("marks")
//    public List<Marks> get() {
//        return this.marksrepo.findAll();
//    }
//
//    @GetMapping("/marks/{id}")
//    public ResponseEntity<Marks> getbyid(@PathVariable("id") Integer id)
//            throws ResourceNotFoundException {
//        Marks marks = marksrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//        return ResponseEntity.ok().body(marks);
//    }
//
//    @PostMapping("marks")
//    public Marks postmarks(@RequestBody Marks marks) {
//        System.out.println(marks);
//        return marksrepo.save(marks);
//    }
//
//    @PutMapping("/marks/{id}")
//    public ResponseEntity<Marks> updatemarks(@PathVariable("id") Integer id, @Validated @RequestBody Marks marksdetials)
//            throws ResourceNotFoundException {
//        Marks marks = marksrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//        marks.subject=marksdetials.subject;
//        marks.marks=marksdetials.marks;
//        return ResponseEntity.ok(this.marksrepo.save(marks));
//
//    }
//    @DeleteMapping("/marks/{id}")
//    public Map<String,Boolean> Deletemarks(@PathVariable(name = "id") Integer id)
//            throws ResourceNotFoundException {
//        Marks marks = marksrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id " + id));
//        this.marksrepo.delete(marks);
//        Map<String,Boolean>response=new HashMap<>();
//        response.put("delete",Boolean.TRUE);
//        return response;
//    }
//
//
//}
