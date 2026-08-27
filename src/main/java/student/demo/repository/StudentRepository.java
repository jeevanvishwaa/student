package student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}