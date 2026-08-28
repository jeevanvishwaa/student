package student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.demo.entity.Student;
import student.demo.repository.StudentRepository;
import student.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE STUDENT
    @PostMapping("/create")
    ResponseEntity<Student> createUser(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    // GET ALL STUDENTS
    @GetMapping
    ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }


    // GET STUDENT BY ID
    @GetMapping("/{id}")
    ResponseEntity<Student> getStudentById(@PathVariable int id) {
        try {
            Student createdStudent = studentService.getStudentById(id);
            return new ResponseEntity<>(createdStudent, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    // DELETE STUDENT
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }

        return "Student not found";
    }
}