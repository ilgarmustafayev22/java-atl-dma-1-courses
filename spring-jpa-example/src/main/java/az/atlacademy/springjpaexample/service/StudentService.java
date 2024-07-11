package az.atlacademy.springjpaexample.service;


import az.atlacademy.springjpaexample.model.dto.StudentDto;
import az.atlacademy.springjpaexample.model.request.StudentRequest;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentRequest studentRequest);

    StudentDto findById(Long id);

    List<StudentDto> findAllStudents();

    void updateStudent(Long id, StudentDto studentDto);

    void deleteStudent(Long id);

}
