package Task1.demo.repo;

import Task1.demo.entity.Studdetials;


import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentdetrepo extends JpaRepository<Studdetials, Integer> {



}