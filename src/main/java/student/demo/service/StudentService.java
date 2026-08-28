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
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(int id, Student student) {

        Student existingStudent = studentRepository.findById((int) id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Integer id) {
        studentRepository.delete(getStudentById(id));
    }
}
