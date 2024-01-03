package Task1.demo.repo;

import Task1.demo.entity.Marks;


import org.springframework.data.jpa.repository.JpaRepository;

public interface Marksrepo extends JpaRepository<Marks, Integer> {


}