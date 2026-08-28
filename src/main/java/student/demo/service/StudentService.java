package student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.demo.entity.Student;
import student.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateTodo(Student student) {
        return studentRepository.save(student);
    }

    public void deleteTodoById(Integer id) {
        studentRepository.delete(getStudentById(id));
    }

    public void deleteTodo(Student student) {
        studentRepository.delete(student);
    }
}
