package Task1.demo.repo;

import Task1.demo.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepo extends JpaRepository<Student, Integer> {


}
