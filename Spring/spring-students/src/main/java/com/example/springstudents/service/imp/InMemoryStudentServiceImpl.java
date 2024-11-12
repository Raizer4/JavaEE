package com.example.springstudents.service.imp;

import com.example.springstudents.model.Student;
import com.example.springstudents.repository.InMemoryStudentDAO;
import com.example.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryStudentServiceImpl implements StudentService {

    private final InMemoryStudentDAO inMemoryStudentDAO;

    @Override
    public List<Student> findAllStudent() {
        return inMemoryStudentDAO.findAllStudent();
    }

    @Override
    public Student saveStudent(Student student) {
        return inMemoryStudentDAO.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return inMemoryStudentDAO.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return inMemoryStudentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        inMemoryStudentDAO.deleteStudent(email);
    }

}
