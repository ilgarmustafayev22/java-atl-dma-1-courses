package az.atl.service;

import az.atl.model.dto.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentService {

    void createStudent(StudentDto studentDto);

    StudentDto findById(Long id);

    List<StudentDto> findAll();


}
