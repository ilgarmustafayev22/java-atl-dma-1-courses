package az.atlacademy.springjdbctemplateexample.controller;

import az.atlacademy.springjdbctemplateexample.model.Student;
import az.atlacademy.springjdbctemplateexample.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException();
        }
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/file-upload")
    public void uploadFile(@RequestBody MultipartFile file){
        try {
            File file1 = new File("C:/Users/ASUS/IdeaProjects/java-atl-dma-1-classes/spring-jdbc-template-example/src/main/java/image/");
            FileOutputStream fos = new FileOutputStream(file1 + "test.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(file.getBytes());
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileExtension(MultipartFile imageFile) {
        return imageFile.getOriginalFilename();
    }

}
