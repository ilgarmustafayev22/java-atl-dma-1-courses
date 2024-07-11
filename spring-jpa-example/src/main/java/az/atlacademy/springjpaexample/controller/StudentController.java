package az.atlacademy.springjpaexample.controller;

import az.atlacademy.springjpaexample.model.dto.StudentDto;
import az.atlacademy.springjpaexample.model.request.StudentRequest;
import az.atlacademy.springjpaexample.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
      // if (studentRequest.getName() == null || studentRequest.getName().isBlank() ||
      //         studentRequest.getSurname() == null ||
      //         studentRequest.getAge() == null) {
      //     throw new NullPointerException("field is null");
      // }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable Long id) {
      //  if (id == null){
      //      throw new NullPointerException("field is null");
      //  }
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id,
                                              @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
