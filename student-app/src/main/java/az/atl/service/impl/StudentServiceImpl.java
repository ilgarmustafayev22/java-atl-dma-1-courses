package az.atl.service.impl;

import az.atl.dao.entity.StudentEntity;
import az.atl.dao.entity.repository.StudentRepository;
import az.atl.mapper.StudentMapper;
import az.atl.model.dto.StudentDto;
import az.atl.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Override
    public void createStudent(StudentDto studentDto) {
        studentRepository.save(studentMapper.toEntity(studentDto));
    }

    @Override
    public StudentDto findById(Long id) {
       return studentRepository.findById(id)
               .map(studentMapper::toDto)
               .orElseThrow();
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

}
