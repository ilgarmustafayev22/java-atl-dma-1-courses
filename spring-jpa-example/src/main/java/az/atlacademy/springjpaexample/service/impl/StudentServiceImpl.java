package az.atlacademy.springjpaexample.service.impl;

import az.atlacademy.springjpaexample.dao.entity.StudentEntity;
import az.atlacademy.springjpaexample.dao.repository.StudentRepository;
import az.atlacademy.springjpaexample.exception.StudentNotFoundException;
import az.atlacademy.springjpaexample.model.dto.StudentDto;
import az.atlacademy.springjpaexample.model.request.StudentRequest;
import az.atlacademy.springjpaexample.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentRequest studentRequest) {
       //StudentEntity studentEntity = new StudentEntity();
       //studentEntity.setName(studentRequest.getName());
       //studentEntity.setSurname(studentRequest.getSurname());
       //studentEntity.setAge(studentRequest.getAge());

        StudentEntity studentEntity = StudentEntity.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .age(studentRequest.getAge())
                .build();

        StudentEntity savedStudent = studentRepository.save(studentEntity);

       //StudentDto studentDto = new StudentDto();
       //studentDto.setId(savedStudent.getId());
       //studentDto.setName(savedStudent.getName());
       //studentDto.setSurname(savedStudent.getSurname());
       //studentDto.setAge(savedStudent.getAge());

        return StudentDto.builder()
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .age(studentEntity.getAge())
                .build();
    }

    @Override
    public StudentDto findById(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

      //  return new StudentDto(studentEntity.getId(),
      //          studentEntity.getName(),
      //          studentEntity.getSurname(),
      //          studentEntity.getAge());
//
        return StudentDto.builder()
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .age(studentEntity.getAge())
                .build();
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll()
                .stream().toList();

        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            studentDtos.add(StudentDto.builder()
                    .name(studentEntity.getName())
                    .surname(studentEntity.getSurname())
                    .age(studentEntity.getAge())
                    .build());
        }
        return studentDtos;
    }

    @Override
    public void updateStudent(Long id, StudentDto studentDto) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setAge(studentDto.getAge());
        studentRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(Long id) {
        // studentRepository.deleteById(id);
        studentRepository.findById(id)
                .ifPresent(studentEntity -> studentRepository.deleteById(id));
    }

}
