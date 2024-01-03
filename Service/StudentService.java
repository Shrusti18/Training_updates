package Task1.demo.Service;

import Task1.demo.entity.Studdetials;
import Task1.demo.entity.Student;
import Task1.demo.repo.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private Studentrepo studentRepository;

    // Other autowired repositories...

    public Student updateStudentDetails(Integer studentId, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();

            // Update student details
            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());

            // Update associated details
            Studdetials studentDetails = existingStudent.getStuddetials();
            if (studentDetails == null) {
                studentDetails = new Studdetials();
                existingStudent.setStuddetials(studentDetails);
            }
            studentDetails.setAddress(updatedStudent.getStuddetials().getAddress());
            studentDetails.setGender(updatedStudent.getStuddetials().getGender());
            // Update associated marks in a similar way

            return studentRepository.save(existingStudent);
        }

        return null; // Or throw an exception
    }

    // Other service methods...
}
